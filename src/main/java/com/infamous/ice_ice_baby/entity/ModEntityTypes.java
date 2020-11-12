package com.infamous.ice_ice_baby.entity;


import com.infamous.ice_ice_baby.client.IceCloudEntity;
import com.infamous.ice_ice_baby.entity.IceologerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.infamous.ice_ice_baby.IceIceBaby.MODID;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);



    public static final RegistryObject<EntityType<IceologerEntity>> ICEOLOGER = ENTITY_TYPES.register("iceologer", () ->
            EntityType.Builder.<IceologerEntity>create(IceologerEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.95F)
                    .func_233606_a_(8)
                    .setCustomClientFactory((spawnEntity,world) -> new IceologerEntity(world))
                    .build(new ResourceLocation(MODID, "iceologer").toString())
    );

    public static final RegistryObject<EntityType<IceCloudEntity>> ICE_CLOUD = ENTITY_TYPES.register("ice_cloud", () ->
            EntityType.Builder.<IceCloudEntity>create(IceCloudEntity::new, EntityClassification.MISC)
                    .immuneToFire()
                    .size(2.0F, 1.0F)
                    .func_233606_a_(6)
                    .func_233608_b_(2)
                    .setCustomClientFactory((spawnEntity,world) -> new IceCloudEntity(world))
                    .build(new ResourceLocation(MODID, "ice_cloud").toString())
    );
}
