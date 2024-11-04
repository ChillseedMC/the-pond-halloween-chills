package net.chillseed.thepondhalloweenchills.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.chillseed.thepondhalloweenchills.ThePondHalloweenChills;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup THE_POND_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ThePondHalloweenChills.MOD_ID, "the_pond"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.the_pond"))
                    .icon(() -> new ItemStack(ModItems.KOI_COIN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KOI_COIN);

                        entries.add(ModItems.BRAIN_HAT);
                        entries.add(ModItems.ARROW_HAT);
                        entries.add(ModItems.CHAINSAW_HAT);
                        entries.add(ModItems.SCREAM_HAT);
                    }).build());


    public static void registerItemGroups() {
        ThePondHalloweenChills.LOGGER.info("Registering Item Groups for " + ThePondHalloweenChills.MOD_ID);
    }
}