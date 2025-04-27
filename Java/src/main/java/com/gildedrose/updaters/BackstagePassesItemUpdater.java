package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassesItemUpdater extends NormalItemUpdater {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    @Override
    public boolean canUpdate(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }
}
