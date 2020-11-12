package com.infamous.ice_ice_baby.entity;

import com.infamous.ice_ice_baby.client.IceCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IceWandItem extends Item {
    public IceWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        if(target != null){
            World world = playerIn.getEntityWorld();
            IceCloudEntity iceCloudEntity = new IceCloudEntity(world, playerIn, target);
            world.addEntity(iceCloudEntity);
            playerIn.getCooldownTracker().setCooldown(ModItems.ICE_WAND.get(), 100);
            stack.damageItem(1, playerIn, playerEntity -> playerEntity.sendBreakAnimation(hand));
            return ActionResultType.SUCCESS;
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }

    public Rarity getRarity(ItemStack itemStack){
        return Rarity.RARE;
    }

}