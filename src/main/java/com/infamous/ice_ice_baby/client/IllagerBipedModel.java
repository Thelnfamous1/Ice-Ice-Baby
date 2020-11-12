package com.infamous.ice_ice_baby.client;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

// Borrowed from tallestred / seymourimadeit's IllagersWearArmor mod
public class IllagerBipedModel<T extends AbstractIllagerEntity> extends BipedModel<T> {
    public ModelRenderer arms;
    public ModelRenderer jacket;

    public IllagerBipedModel(float modelSize, float p_i47227_2_, int textureWidthIn, int textureHeightIn) {
        super(modelSize);
        this.bipedHead = (new ModelRenderer(this)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedHead.setRotationPoint(0.0F, 0.0F + p_i47227_2_, 0.0F);
        this.bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, modelSize);
        this.bipedHeadwear = (new ModelRenderer(this, 32, 0)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedHeadwear.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 12.0F, 8.0F, modelSize + 0.45F);
        this.bipedHeadwear.showModel = false;
        ModelRenderer modelrenderer = (new ModelRenderer(this)).setTextureSize(textureWidthIn, textureHeightIn);
        modelrenderer.setRotationPoint(0.0F, p_i47227_2_ - 2.0F, 0.0F);
        modelrenderer.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, modelSize);
        this.bipedHead.addChild(modelrenderer);
        this.bipedBody = (new ModelRenderer(this)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedBody.setRotationPoint(0.0F, 0.0F + p_i47227_2_, 0.0F);
        this.bipedBody.setTextureOffset(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, modelSize);
        this.jacket = (new ModelRenderer(this)).setTextureSize(textureWidthIn, textureHeightIn);
        this.jacket.setRotationPoint(0.0F, 0.0F + p_i47227_2_, 0.0F);
        this.jacket.setTextureOffset(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, modelSize + 0.5F);
        this.arms = (new ModelRenderer(this)).setTextureSize(textureWidthIn, textureHeightIn);
        this.arms.setRotationPoint(0.0F, 0.0F + p_i47227_2_ + 2.0F, 0.0F);
        this.arms.setTextureOffset(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, modelSize);
        ModelRenderer modelrenderer1 = (new ModelRenderer(this, 44, 22)).setTextureSize(textureWidthIn, textureHeightIn);
        modelrenderer1.mirror = true;
        modelrenderer1.addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, modelSize);
        this.arms.addChild(modelrenderer1);
        this.arms.setTextureOffset(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, modelSize);
        this.bipedLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedLeftLeg.setRotationPoint(-2.0F, 12.0F + p_i47227_2_, 0.0F);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedRightLeg.mirror = true;
        this.bipedRightLeg.setRotationPoint(2.0F, 12.0F + p_i47227_2_, 0.0F);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedRightArm = (new ModelRenderer(this, 40, 46)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + p_i47227_2_, 0.0F);
        this.bipedLeftArm = (new ModelRenderer(this, 40, 46)).setTextureSize(textureWidthIn, textureHeightIn);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + p_i47227_2_, 0.0F);
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.arms, this.jacket));
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        ItemStack mainhand = entityIn.getHeldItemMainhand();
        ItemStack offhand = entityIn.getHeldItemOffhand();
        UseAction useaction = mainhand.getUseAction();

        // Needed for shields to be angled properly
        if(entityIn.isActiveItemStackBlocking() && entityIn.getActiveItemStack() == offhand) useaction = UseAction.BLOCK;

        this.rightArmPose = BipedModel.ArmPose.EMPTY;
        this.leftArmPose = BipedModel.ArmPose.EMPTY;
        if (entityIn.getPrimaryHand() == HandSide.RIGHT && entityIn.getArmPose() != AbstractIllagerEntity.ArmPose.CROSSED) {
            switch (useaction) {
                case BLOCK:
                    // Added for shield compatibility
                    this.leftArmPose = BipedModel.ArmPose.BLOCK;
                    this.rightArmPose = BipedModel.ArmPose.EMPTY;
                    if (!mainhand.isEmpty()) {
                        this.rightArmPose = BipedModel.ArmPose.ITEM;
                    }
                    break;
                case CROSSBOW:
                    this.rightArmPose = BipedModel.ArmPose.CROSSBOW_HOLD;
                    if (entityIn.isHandActive()) {
                        this.rightArmPose = BipedModel.ArmPose.CROSSBOW_CHARGE;
                    }
                    break;
                case BOW:
                    this.rightArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
                    break;
                default:
                    this.rightArmPose = BipedModel.ArmPose.EMPTY;
                    if (!mainhand.isEmpty()) {
                        this.rightArmPose = BipedModel.ArmPose.ITEM;
                    }
                    // Added for shield visibility when not attacking
                    if(offhand.isShield(entityIn)){
                        this.leftArmPose = ArmPose.ITEM;
                    }
                    break;
            }
        }
        if (entityIn.getPrimaryHand() == HandSide.LEFT && entityIn.getArmPose() != AbstractIllagerEntity.ArmPose.CROSSED) {
            switch (useaction) {
                case BLOCK:
                    // Added for shield compatibility
                    this.rightArmPose = BipedModel.ArmPose.BLOCK;
                    this.leftArmPose = BipedModel.ArmPose.EMPTY;
                    if (!mainhand.isEmpty()) {
                        this.leftArmPose = BipedModel.ArmPose.ITEM;
                    }
                    break;
                case CROSSBOW:
                    this.leftArmPose = BipedModel.ArmPose.CROSSBOW_HOLD;
                    if (entityIn.isHandActive()) {
                        this.leftArmPose = BipedModel.ArmPose.CROSSBOW_CHARGE;
                    }
                    break;
                case BOW:
                    this.leftArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
                    break;
                default:
                    this.leftArmPose = BipedModel.ArmPose.EMPTY;
                    if (!mainhand.isEmpty()) {
                        this.leftArmPose = BipedModel.ArmPose.ITEM;
                    }
                    // Added for shield visibility when not attacking
                    if(offhand.isShield(entityIn)){
                        this.rightArmPose = ArmPose.ITEM;
                    }
                    break;
            }
        }
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        AbstractIllagerEntity.ArmPose armpose = entityIn.getArmPose();
        this.arms.rotationPointY = 3.0F;
        this.arms.rotationPointZ = -1.0F;
        this.arms.rotateAngleX = -0.75F;
        this.jacket.copyModelAngles(bipedBody);
        boolean isWearingChestplateOrLeggings = entityIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem || entityIn.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem;
        this.jacket.showModel = !isWearingChestplateOrLeggings;
        boolean flag = armpose == AbstractIllagerEntity.ArmPose.CROSSED;
        this.arms.showModel = flag;
        this.bipedLeftArm.showModel = !flag;
        this.bipedRightArm.showModel = !flag;
        if (flag) {
            this.bipedLeftArm.rotationPointY = 3.0F;
            this.bipedLeftArm.rotationPointZ = -1.0F;
            this.bipedLeftArm.rotateAngleX = -0.75F;
            this.bipedRightArm.rotationPointY = 3.0F;
            this.bipedRightArm.rotationPointZ = -1.0F;
            this.bipedRightArm.rotateAngleX = -0.75F;
        }
        switch (armpose) {
            case ATTACKING:
                if (!entityIn.getHeldItemMainhand().isEmpty()
                        && !(entityIn.getHeldItemMainhand().getItem() instanceof ShootableItem)
                        && !(entityIn.isActiveItemStackBlocking())){
                    // raises arm with weapon, moves left arm back and forth while attacking
                    ModelHelper.func_239103_a_(this.bipedRightArm, this.bipedLeftArm, entityIn, this.swingProgress, ageInTicks);
                }
                else if(!entityIn.getHeldItemMainhand().isEmpty()
                        && !(entityIn.getHeldItemMainhand().getItem() instanceof ShootableItem)){
                    ModelUtils.readyWeaponWhileBlocking(this.bipedRightArm, this.bipedLeftArm, entityIn, this.swingProgress, ageInTicks);
                }
                break;
            case CELEBRATING:
                this.bipedRightArm.rotationPointZ = 0.0F;
                this.bipedRightArm.rotationPointX = -5.0F;
                this.bipedRightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.05F;
                this.bipedRightArm.rotateAngleZ = 2.670354F;
                this.bipedRightArm.rotateAngleY = 0.0F;
                this.bipedLeftArm.rotationPointZ = 0.0F;
                this.bipedLeftArm.rotationPointX = 5.0F;
                this.bipedLeftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.05F;
                this.bipedLeftArm.rotateAngleZ = -2.3561945F;
                this.bipedLeftArm.rotateAngleY = 0.0F;
                break;
            case SPELLCASTING:
                this.bipedRightArm.rotationPointZ = 0.0F;
                this.bipedRightArm.rotationPointX = -5.0F;
                this.bipedLeftArm.rotationPointZ = 0.0F;
                this.bipedLeftArm.rotationPointX = 5.0F;
                this.bipedRightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
                this.bipedLeftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
                this.bipedRightArm.rotateAngleZ = 2.3561945F;
                this.bipedLeftArm.rotateAngleZ = -2.3561945F;
                this.bipedRightArm.rotateAngleY = 0.0F;
                this.bipedLeftArm.rotateAngleY = 0.0F;
                break;
            default:
                break;
        }
    }
}