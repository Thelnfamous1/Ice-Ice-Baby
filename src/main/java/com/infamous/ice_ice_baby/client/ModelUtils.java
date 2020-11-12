package com.infamous.ice_ice_baby.client;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class ModelUtils {

    public static <T extends MobEntity> void readyWeaponWhileBlocking(ModelRenderer rightArm, ModelRenderer leftArm, T entityIn, float swingProgress, float ageInTicks) {
        float lvt_5_1_ = MathHelper.sin(swingProgress * 3.1415927F);
        float lvt_6_1_ = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * 3.1415927F);


        if (entityIn.getPrimaryHand() == HandSide.RIGHT) {

            rightArm.rotateAngleZ = 0.0F;
            //leftArm.rotateAngleZ = 0.0F;
            rightArm.rotateAngleY = 0.15707964F;
            //leftArm.rotateAngleY = -0.15707964F;


            rightArm.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
            //leftArm.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
            rightArm.rotateAngleX += lvt_5_1_ * 2.2F - lvt_6_1_ * 0.4F;
            //leftArm.rotateAngleX += lvt_5_1_ * 1.2F - lvt_6_1_ * 0.4F;




            rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            //leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            //leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

        } else {

            //rightArm.rotateAngleZ = 0.0F;
            leftArm.rotateAngleZ = 0.0F;
            //rightArm.rotateAngleY = 0.15707964F;
            leftArm.rotateAngleY = -0.15707964F;

            //rightArm.rotateAngleX = -0.0F + MathHelper.cos(ageInTicks * 0.19F) * 0.5F;
            leftArm.rotateAngleX = -1.8849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
            //rightArm.rotateAngleX += lvt_5_1_ * 1.2F - lvt_6_1_ * 0.4F;
            leftArm.rotateAngleX += lvt_5_1_ * 2.2F - lvt_6_1_ * 0.4F;




            //rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            //rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        }
    }
}
