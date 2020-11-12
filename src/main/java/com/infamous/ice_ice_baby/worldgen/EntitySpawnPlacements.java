package com.infamous.ice_ice_baby.worldgen;

import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.gen.Heightmap;

public class EntitySpawnPlacements {

    public static void initSpawnPlacements(){
        EntitySpawnPlacementRegistry.register(ModEntityTypes.ICEOLOGER.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MonsterEntity::canMonsterSpawnInLight);

    }

}
