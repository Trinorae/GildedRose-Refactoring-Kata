package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.qualitybehaviour.DecreaseQualityBehaviour;

public class NormalItemUpdater implements ItemUpdater, DecreaseQualityBehaviour {

    @Override
    public void update(Item item) {
        item.sellIn--;
        int decrease = item.sellIn < 0 ? 2 : 1;
        decreaseQuality(item, decrease);
    }

    @Override
    public boolean accepts(Item item) {
        return true;
    }
}
