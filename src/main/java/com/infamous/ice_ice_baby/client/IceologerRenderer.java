package com.infamous.ice_ice_baby.client;

import com.infamous.ice_ice_baby.entity.IceologerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.util.ResourceLocation;

import static com.infamous.ice_ice_baby.IceIceBaby.MODID;

public class IceologerRenderer extends MobRenderer<IceologerEntity, IllagerBipedModel<IceologerEntity>> {

    private static final ResourceLocation ICEOLOGER_TEXTURE = new ResourceLocation(MODID,"textures/entity/illager/iceologer.png");

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public IceologerRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new IllagerBipedModel<>(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new HeadLayer<>(this));
        this.addLayer(new BipedArmorLayer(this, new IllagerArmorModel(0.5F), new IllagerArmorModel(1.0F)));
        this.addLayer(new IceologerCapeLayer(this));
        this.addLayer(new HeldItemLayer<IceologerEntity, IllagerBipedModel<IceologerEntity>>(this) {
            @Override
            public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, IceologerEntity iceologerEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                if (iceologerEntity.isSpellcasting() || iceologerEntity.isAggressive() || iceologerEntity.getArmPose() == AbstractIllagerEntity.ArmPose.NEUTRAL) {
                    super.render(matrixStackIn, bufferIn, packedLightIn, iceologerEntity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
                }
            }
        });
        this.entityModel.bipedHeadwear.showModel = true; // apparently this cost tallestred hours of his life
    }

    @Override
    protected void preRenderCallback(IceologerEntity iceologerEntity, MatrixStack matrixStack, float v) {
        float scaleFactor = 0.9375F;
        matrixStack.scale(scaleFactor, scaleFactor, scaleFactor);
        super.preRenderCallback(iceologerEntity, matrixStack, v);
    }

    @Override
    public ResourceLocation getEntityTexture(IceologerEntity entity) {
        return ICEOLOGER_TEXTURE;
    }
}
