/*License
Part of the code is based on the "Villager Hats Mod" source code by PinkGoosik
https://github.com/PinkGoosik/villager-hats
 */

package net.chillseed.thepondhalloweenchills.compat;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.chillseed.thepondhalloweenchills.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.chillseed.thepondhalloweenchills.item.hats.HatTrinket;
import net.chillseed.thepondhalloweenchills.client.render.HatTrinketRenderer;

import java.util.Optional;

/**
 * Whatever method from this class should only
 * be called after FabricLoader.getInstance().isModLoaded("trinkets")
 */
public class TrinketsCompat {

    public static void onInitializeClient() {
        ModItems.HAT_ITEMS.forEach((id, item) -> TrinketRendererRegistry.registerRenderer(item, new HatTrinketRenderer()));
    }

    public static boolean hasHat(PlayerEntity player) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);
        if(component.isPresent()) {
            for(Pair<SlotReference, ItemStack> pair : component.get().getAllEquipped()) {
                if(pair.getRight().getItem() instanceof HatTrinket) return true;
            }
        }
        return false;
    }

    public static Item createTrinket(String name, float size, double height) {
        return new HatTrinket(name, size, height);
    }

}