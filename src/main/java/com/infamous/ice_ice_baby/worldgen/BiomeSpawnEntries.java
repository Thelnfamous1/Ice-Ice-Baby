package com.infamous.ice_ice_baby.worldgen;


import com.infamous.ice_ice_baby.IceIceBabyConfig;
import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeSpawnEntries {

    public static void initBiomeSpawnEntries(){
        for(Biome biome : ForgeRegistries.BIOMES){
            if(IceIceBabyConfig.COMMON.ENABLE_ICEOLOGER_SPAWNS.get()){
                handleIceologer(biome);
            }
        }
    }

    private static void handleIceologer(Biome biome) {
        boolean isSpawnableBiome = biome.getCategory() == Biome.Category.ICY || biome.getPrecipitation() == Biome.RainType.SNOW;
        if(isSpawnableBiome){
            List<Biome.SpawnListEntry> monsterSpawnList = biome.getSpawns(EntityClassification.MONSTER);
            Biome.SpawnListEntry wraithSpawnEntry =
                    new Biome.SpawnListEntry(
                            ModEntityTypes.ICEOLOGER.get(),
                            IceIceBabyConfig.COMMON.ICEOLOGER_SPAWN_WEIGHT.get(),
                            IceIceBabyConfig.COMMON.ICEOLOGER_MIN_SPAWN_GROUP_SIZE.get(),
                            IceIceBabyConfig.COMMON.ICEOLOGER_MAX_SPAWN_GROUP_SIZE.get());
            monsterSpawnList.add(wraithSpawnEntry);
        }
    }
}
