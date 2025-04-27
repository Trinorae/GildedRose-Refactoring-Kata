package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.qualitybehaviour.IncreaseQualityBehaviour;

public class AgedBrieItemUpdater implements ItemUpdater, IncreaseQualityBehaviour {

    @Override
    public void update(Item item) {
        item.sellIn--;
        int increase = item.sellIn < 0 ? 2 : 1;
        increaseQuality(item, increase);
    }

    @Override
    public boolean accepts(Item item) {
        return "Aged Brie".equals(item.name);
    }
}
