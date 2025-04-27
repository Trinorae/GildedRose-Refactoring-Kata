package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.qualitybehaviour.DecreaseQualityBehaviour;

public class ConjuredItemUpdater implements ItemUpdater, DecreaseQualityBehaviour {

    @Override
    public void update(Item item) {
        item.sellIn--;
        int decrease = item.sellIn < 0 ? 4 : 2;
        decreaseQuality(item, decrease);
    }

    @Override
    public boolean accepts(Item item) {
        return item.name != null && item.name.startsWith("Conjured");
    }
}
