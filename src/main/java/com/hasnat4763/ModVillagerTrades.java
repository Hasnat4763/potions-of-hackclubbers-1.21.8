package com.hasnat4763;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import static com.hasnat4763.PotionsOfHackClubbers.MOD_ID;
import static com.hasnat4763.item.ModItems.HEIDI_TAIL;

public class ModVillagerTrades {
    public static void RegisterModVillagerTrades() {
        PotionsOfHackClubbers.LOGGER.info("Registering villager trades for " + MOD_ID);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories ->
                factories.add((entity, random) -> new TradeOffer(
                        new TradedItem(Items.EMERALD, 20),
                        new ItemStack(HEIDI_TAIL, 1),
                        16, 2, 0.02f))
        );

        TradeOfferHelper.registerWanderingTraderOffers(factories ->
            factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 10),
                            new ItemStack(HEIDI_TAIL, 1),
                            16,
                            2,
                            0.02f
                    )
            )
        );
    }
}
