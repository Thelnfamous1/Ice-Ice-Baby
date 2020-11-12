package com.infamous.ice_ice_baby.worldgen;


import com.infamous.ice_ice_baby.entity.IceologerEntity;
import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class EntityTypeAttributes {

    public static void initEntityTypeAttributes() {
        GlobalEntityTypeAttributes.put(ModEntityTypes.ICEOLOGER.get(), IceologerEntity.setCustomAttributes().create());

    }
}
