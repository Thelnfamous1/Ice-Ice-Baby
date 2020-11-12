package com.infamous.ice_ice_baby.entity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.infamous.ice_ice_baby.IceIceBaby.MODID;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<ModSpawnEggItem> ICEOLOGER_SPAWN_EGG = ITEMS.register("iceologer_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.ICEOLOGER,
                    0x000080, 0xD6D1CD,
                    new Item.Properties().group(ItemGroup.MISC)));

    public static final RegistryObject<IceWandItem> ICE_WAND = ITEMS.register("ice_wand",
            () -> new IceWandItem(new Item.Properties().group(ItemGroup.COMBAT).maxDamage(64)));
}
