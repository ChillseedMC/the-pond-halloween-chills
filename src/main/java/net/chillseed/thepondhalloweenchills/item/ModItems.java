/*License
Part of the code is based on the "Villager Hats Mod" source code by PinkGoosik
https://github.com/PinkGoosik/villager-hats
 */

package net.chillseed.thepondhalloweenchills.item;

import net.chillseed.thepondhalloweenchills.ThePondHalloweenChills;
import net.chillseed.thepondhalloweenchills.item.armor.ThePondHatArmor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.chillseed.thepondhalloweenchills.compat.TrinketsCompat;
import net.chillseed.thepondhalloweenchills.item.hats.Hat;
import net.chillseed.thepondhalloweenchills.item.hats.HatItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    public static final Item KOI_COIN = registerItem("koi_coin", new Item(new FabricItemSettings()));

    //Experimental custom armor item but without 3D model yet
    public static final Item BRAIN_HAT_HELMET = registerItem("brain_hat_helmet",
            new ThePondHatArmor(ModArmorMaterials.POND_CLOTHING_MATERIAL, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Map<Identifier, Item> HAT_ITEMS = new LinkedHashMap<>();
    public static final Item BRAIN_HAT = add_hat("brain", 1.0F, -0.47D);
    public static final Item ARROW_HAT = add_hat("arrow", 1.0F, -0.47D);
    public static final Item CHAINSAW_HAT = add_hat("chainsaw", 1.0F, -0.47D);
    public static final Item SCREAM_HAT = add_hat("scream", 1.0F, -0.47D);

    /*
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(KOI_COIN);
    }
    */

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ThePondHalloweenChills.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ThePondHalloweenChills.LOGGER.info("Registering Mod Items for " + ThePondHalloweenChills.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        for (Identifier id : HAT_ITEMS.keySet()) {
            Registry.register(Registries.ITEM, id, HAT_ITEMS.get(id));
        }
    }

    private static Item add_hat(String hat_name, float size, double height) {
        Item item;

        if(FabricLoader.getInstance().isModLoaded("trinkets")) {
            item = TrinketsCompat.createTrinket(hat_name, size, height);
        }
        else item = new HatItem(hat_name, size, height);

        HAT_ITEMS.put(new Identifier(ThePondHalloweenChills.MOD_ID, ((Hat)item).getHatName()), item);
        return item;
    }
}
