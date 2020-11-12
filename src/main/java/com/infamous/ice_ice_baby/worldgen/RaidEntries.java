package com.infamous.ice_ice_baby.worldgen;

import com.infamous.ice_ice_baby.IceIceBabyConfig;
import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import net.minecraft.world.raid.Raid;

public class RaidEntries {

    public static void initWaveMemberEntries(){
        /*
      VINDICATOR(EntityType.VINDICATOR, new int[]{0, 0, 2, 0, 1, 4, 2, 5}),
      EVOKER(EntityType.EVOKER, new int[]{0, 0, 0, 0, 0, 1, 1, 2}),
      PILLAGER(EntityType.PILLAGER, new int[]{0, 4, 3, 3, 4, 4, 4, 2}),
      WITCH(EntityType.WITCH, new int[]{0, 0, 0, 0, 3, 0, 0, 1}),
      RAVAGER(EntityType.RAVAGER, new int[]{0, 0, 0, 1, 0, 1, 0, 2});
         */
        if(IceIceBabyConfig.COMMON.ENABLE_ICEOLOGERS_IN_RAIDS.get()){
            Raid.WaveMember.create("iceologer", ModEntityTypes.ICEOLOGER.get(), new int[] {0, 0, 0, 0, 0, 1, 1, 2});
        }
    }
}
