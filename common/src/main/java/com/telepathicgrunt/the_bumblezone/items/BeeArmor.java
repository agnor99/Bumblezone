package com.telepathicgrunt.the_bumblezone.items;

import com.telepathicgrunt.the_bumblezone.modcompat.BackpackedCompat;
import com.telepathicgrunt.the_bumblezone.modcompat.ModChecker;
import com.telepathicgrunt.the_bumblezone.modcompat.ModCompat;
import com.telepathicgrunt.the_bumblezone.modinit.BzTags;
import com.telepathicgrunt.the_bumblezone.platform.ItemExtension;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class BeeArmor extends BzArmor implements ItemExtension {
    private final int variant;
    private final boolean transTexture;

    public BeeArmor(ArmorMaterial material, ArmorItem.Type armorType, Properties properties, int variant, boolean transTexture) {
        super(material, armorType, properties);
        this.variant = variant;
        this.transTexture = transTexture;
    }

    public boolean hasTransTexture() {
        return transTexture;
    }

    public int getVariant() {
        return variant;
    }

    public void bz$onArmorTick(ItemStack itemstack, Level world, Player player) { }

    public static int getBeeThemedGearCount(Entity entity) {
        int beeGearCount = 0;
        for(ItemStack armor : entity.getArmorSlots()) {
            if(armor.is(BzTags.BZ_ARMOR_ABILITY_ENHANCING_GEAR)) {
                if (isAllowedBeeArmorBoosting(armor)) {
                    beeGearCount++;
                }
            }
        }
        for (ModCompat compat : ModChecker.CUSTOM_EQUIPMENT_SLOTS_COMPATS) {
            beeGearCount += compat.getNumberOfMatchingEquippedItemsInCustomSlots(entity, (itemStack) -> {
                if (itemStack.is(BzTags.BZ_ARMOR_ABILITY_ENHANCING_GEAR)) {
                    return !ModChecker.backpackedPresent || BackpackedCompat.isBackpackedHoneyThemedOrOtherItem(itemStack);
                }
                return false;
            });
        }
        return beeGearCount;
    }

    private static boolean isAllowedBeeArmorBoosting(ItemStack armor) {
        for (ModCompat compat : ModChecker.BEE_GEAR_BOOSTING_COMPATS) {
            if (compat.isItemExplicitlyDisallowedFromBeeGearBoosting(armor)) {
                return false;
            }
        }
        return true;
    }
}