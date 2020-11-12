package com.infamous.ice_ice_baby.client;

import com.infamous.ice_ice_baby.entity.IceologerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.infamous.ice_ice_baby.IceIceBaby.MODID;

@OnlyIn(Dist.CLIENT)
public class IceologerCapeLayer extends LayerRenderer<IceologerEntity, IllagerBipedModel<IceologerEntity>> {

    private static final ResourceLocation ICEOLOGER_CAPE_TEXTURE = new ResourceLocation(MODID,"textures/entity/illager/iceologer_cape.png");

    ModdedCapeModel iceologerCapeModel = new ModdedCapeModel(0.0F);

    public IceologerCapeLayer(IEntityRenderer<IceologerEntity, IllagerBipedModel<IceologerEntity>> iceologerRendererIn) {
        super(iceologerRendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, IceologerEntity illagerEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!illagerEntity.isInvisible()) {
            ItemStack itemstack = illagerEntity.getItemStackFromSlot(EquipmentSlotType.CHEST);
            if (itemstack.getItem() != Items.ELYTRA) {
                matrixStackIn.push();
                double capePositionAdjustment = 0.1D;
                matrixStackIn.translate(0.0D, 0.0D, 0.125D + capePositionAdjustment);
                double d0 = MathHelper.lerp((double)partialTicks, illagerEntity.prevChasingPosX, illagerEntity.chasingPosX) - MathHelper.lerp((double)partialTicks, illagerEntity.prevPosX, illagerEntity.getPosX());
                double d1 = MathHelper.lerp((double)partialTicks, illagerEntity.prevChasingPosY, illagerEntity.chasingPosY) - MathHelper.lerp((double)partialTicks, illagerEntity.prevPosY, illagerEntity.getPosY());
                double d2 = MathHelper.lerp((double)partialTicks, illagerEntity.prevChasingPosZ, illagerEntity.chasingPosZ) - MathHelper.lerp((double)partialTicks, illagerEntity.prevPosZ, illagerEntity.getPosZ());
                float f = illagerEntity.prevRenderYawOffset + (illagerEntity.renderYawOffset - illagerEntity.prevRenderYawOffset);
                double d3 = (double) MathHelper.sin(f * ((float)Math.PI / 180F));
                double d4 = (double)(-MathHelper.cos(f * ((float)Math.PI / 180F)));
                float f1 = (float)d1 * 10.0F;
                f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
                float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
                f2 = MathHelper.clamp(f2, 0.0F, 150.0F);
                float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
                f3 = MathHelper.clamp(f3, -20.0F, 20.0F);
                if (f2 < 0.0F) {
                    f2 = 0.0F;
                }

                float f4 = MathHelper.lerp(partialTicks, illagerEntity.prevCameraYaw, illagerEntity.cameraYaw);
                f1 = f1 + MathHelper.sin(MathHelper.lerp(partialTicks, illagerEntity.prevDistanceWalkedModified, illagerEntity.distanceWalkedModified) * 6.0F) * 32.0F * f4;
                if (illagerEntity.isCrouching()) {
                    f1 += 25.0F;
                }

                matrixStackIn.rotate(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
                matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f3 / 2.0F));
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - f3 / 2.0F));
                IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(ICEOLOGER_CAPE_TEXTURE));
                this.iceologerCapeModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY);
                matrixStackIn.pop();
            }
        }

    }
}