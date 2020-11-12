package com.infamous.ice_ice_baby;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class IceIceBabyConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ICEOLOGER_SPAWNS;
        public final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ICEOLOGERS_IN_RAIDS;
        public final ForgeConfigSpec.ConfigValue<Integer> ICEOLOGER_SPAWN_WEIGHT;
        public final ForgeConfigSpec.ConfigValue<Integer> ICEOLOGER_MIN_SPAWN_GROUP_SIZE;
        public final ForgeConfigSpec.ConfigValue<Integer> ICEOLOGER_MAX_SPAWN_GROUP_SIZE;

        public Common(ForgeConfigSpec.Builder builder){

            builder.comment("Mob Configuration").push("mob_configuration");
            ENABLE_ICEOLOGER_SPAWNS = builder
                    .comment("Enable Iceologers to spawn in snowy or icy biomes. \n" +
                            "If you have an alternative way to spawn them, disable this feature. [true / false]")
                    .define("enableIceologerSpawns", true);
            ENABLE_ICEOLOGERS_IN_RAIDS = builder
                    .comment("Enable Iceologers to spawn in raids, in the same waves as the Evoker. \n" +
                            "If you don't want them to spawn in raids, disable this feature. [true / false]")
                    .define("enableIceolgersInRaids", true);
            ICEOLOGER_SPAWN_WEIGHT = builder
                    .comment("Spawn weight of iceologers in snowy or icy biomes.")
                    .defineInRange("iceologerSpawnWeight", 5, 0, 1024);
            ICEOLOGER_MIN_SPAWN_GROUP_SIZE = builder
                    .comment("Minimum spawn group size of iceologers in snowy or icy biomes.")
                    .defineInRange("iceolgoerMinSpawnGroupSize", 1, 0, 1024);
            ICEOLOGER_MAX_SPAWN_GROUP_SIZE = builder
                    .comment("Maximum spawn group size of iceologers in snowy or icy biomes.")
                    .defineInRange("iceologerMaxSpawnGroupSize", 1, 0, 1024);
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}
