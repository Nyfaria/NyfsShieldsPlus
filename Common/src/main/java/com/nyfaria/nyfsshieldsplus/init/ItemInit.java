package com.nyfaria.nyfsshieldsplus.init;

import com.nyfaria.grinnersents.registration.RegistrationProvider;
import com.nyfaria.grinnersents.registration.RegistryObject;
import com.nyfaria.nyfsshieldsplus.Constants;
import com.nyfaria.nyfsshieldsplus.item.AdvancedShieldItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);
    public static final RegistryObject<Item> ADVANCED_SHIELD = ITEMS.register("advanced_shield", () -> new AdvancedShieldItem(getItemProperties()));

    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }

    public static void loadClass() {
    }
}
