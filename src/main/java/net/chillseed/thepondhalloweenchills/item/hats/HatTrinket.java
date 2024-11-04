/*License
Part of the code is based on the "Villager Hats Mod" source code by PinkGoosik
https://github.com/PinkGoosik/villager-hats
 */

package net.chillseed.thepondhalloweenchills.item.hats;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;

public class HatTrinket extends TrinketItem implements Hat {
    private final float size;
    private final double height;
    private final String name;

    public HatTrinket(String name, float size, double height) {
        super(new FabricItemSettings());
        this.size = size;
        this.height = height;
        this.name = name;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
        entity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 1.0F);
    }

    @Override
    public String getHatName() {
        return name + "_hat";
    }

    @Override
    public float getSize() {
        return size;
    }

    @Override
    public double getHeight() {
        return height;
    }

}
