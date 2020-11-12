package com.infamous.ice_ice_baby.client;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.monster.AbstractIllagerEntity;

// Borrowed from tallestred / seymourimadeit's IllagersWearArmor mod
public class IllagerArmorModel extends BipedModel<AbstractIllagerEntity> {
    public IllagerArmorModel(float modelSizeIn) {
        super(modelSizeIn);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSizeIn);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
}