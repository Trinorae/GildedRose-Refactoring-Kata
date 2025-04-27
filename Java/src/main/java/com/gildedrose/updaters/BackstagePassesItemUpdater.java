package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.qualitybehaviour.IncreaseQualityBehaviour;

public class BackstagePassesItemUpdater implements ItemUpdater, IncreaseQualityBehaviour {

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            int increase = determineQualityIncrease(item.sellIn);
            increaseQuality(item, increase);
        }
    }

    private int determineQualityIncrease(int sellIn) {
        if (sellIn < 5) {
            return 3;
        } else if (sellIn < 10) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public boolean canUpdate(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }
}
