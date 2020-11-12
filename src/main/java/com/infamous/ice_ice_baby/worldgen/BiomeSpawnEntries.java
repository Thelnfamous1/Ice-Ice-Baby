package com.infamous.ice_ice_baby.worldgen;


import com.infamous.ice_ice_baby.IceIceBaby;
import com.infamous.ice_ice_baby.IceIceBabyConfig;
import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = IceIceBaby.MODID)
public class BiomeSpawnEntries {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoad(BiomeLoadingEvent event){
        if(IceIceBabyConfig.COMMON.ENABLE_ICEOLOGER_SPAWNS.get()){
            Biome.Category category = event.getCategory();
            Biome.Climate climate = event.getClimate();
            if(category == Biome.Category.ICY || climate.precipitation == Biome.RainType.SNOW){
                MobSpawnInfoBuilder mobSpawnInfoBuilder = event.getSpawns();
                List<MobSpawnInfo.Spawners> spawnersList = mobSpawnInfoBuilder.getSpawner(EntityClassification.MONSTER);
                MobSpawnInfo.Spawners iceologerSpawner = new MobSpawnInfo.Spawners(
                        ModEntityTypes.ICEOLOGER.get(),
                        IceIceBabyConfig.COMMON.ICEOLOGER_SPAWN_WEIGHT.get(),
                        IceIceBabyConfig.COMMON.ICEOLOGER_MIN_SPAWN_GROUP_SIZE.get(),
                        IceIceBabyConfig.COMMON.ICEOLOGER_MAX_SPAWN_GROUP_SIZE.get());
                spawnersList.add(iceologerSpawner);
            }
        }
    }
}
