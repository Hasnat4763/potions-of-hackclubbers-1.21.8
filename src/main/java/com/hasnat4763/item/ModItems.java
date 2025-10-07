package com.hasnat4763.item;


import com.hasnat4763.PotionsOfHackClubbers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.hasnat4763.PotionsOfHackClubbers.MOD_ID;


public class ModItems {

    public static Item POTION_HEAVYSOB = registerItem("heavysob_potion", Item::new, new Item.Settings());
    public static Item POTION_EGGER = registerItem("egger_potion", Item::new, new Item.Settings());
    public static Item POTION_SADGE = registerItem("sadge_potion", Item::new, new Item.Settings());







    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
    public static void RegisterModItems(){
        PotionsOfHackClubbers.LOGGER.info("Registering items for " + MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries->{
            entries.add(POTION_HEAVYSOB);
            entries.add(POTION_EGGER);
            entries.add(POTION_SADGE);
        });

    }
}
