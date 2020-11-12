package com.infamous.ice_ice_baby;

import com.infamous.ice_ice_baby.client.IceCloudRenderer;
import com.infamous.ice_ice_baby.client.IceologerRenderer;
import com.infamous.ice_ice_baby.entity.ModEntityTypes;
import com.infamous.ice_ice_baby.entity.ModItems;
import com.infamous.ice_ice_baby.worldgen.BiomeSpawnEntries;
import com.infamous.ice_ice_baby.worldgen.EntitySpawnPlacements;
import com.infamous.ice_ice_baby.worldgen.EntityTypeAttributes;
import com.infamous.ice_ice_baby.worldgen.RaidEntries;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ice_ice_baby")
public class IceIceBaby
{
    // Directly reference a log4j logger.
    public static final String MODID = "ice_ice_baby";
    public static final Logger LOGGER = LogManager.getLogger();

    public IceIceBaby() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, IceIceBabyConfig.COMMON_SPEC);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            EntityTypeAttributes.initEntityTypeAttributes();
            BiomeSpawnEntries.initBiomeSpawnEntries();
            EntitySpawnPlacements.initSpawnPlacements();
            RaidEntries.initWaveMemberEntries();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ICEOLOGER.get(), IceologerRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ICE_CLOUD.get(), IceCloudRenderer::new);

    }
}
