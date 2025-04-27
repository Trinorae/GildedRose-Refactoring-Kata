package com.gildedrose;

import com.gildedrose.updaters.AgedBrieItemUpdater;
import com.gildedrose.updaters.BackstagePassesItemUpdater;
import com.gildedrose.updaters.ConjuredItemUpdater;
import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.NormalItemUpdater;
import com.gildedrose.updaters.SulfurasItemUpdater;

import java.util.List;

public class ItemUpdaterFactory {

    static List<ItemUpdater> itemUpdaters = List.of(
        new AgedBrieItemUpdater(),
        new BackstagePassesItemUpdater(),
        new SulfurasItemUpdater(),
        new ConjuredItemUpdater()
    );

    static ItemUpdater defaultUpdater = new NormalItemUpdater();

    public static ItemUpdater getItemUpdater(Item item) {
        return itemUpdaters.stream()
            .filter(updater -> updater.canUpdate(item))
            .findFirst()
            .orElse(defaultUpdater);
    }
}
