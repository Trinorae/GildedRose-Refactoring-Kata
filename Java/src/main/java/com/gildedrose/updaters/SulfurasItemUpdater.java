package com.gildedrose.updaters;

import com.gildedrose.Item;

public class SulfurasItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        // Sulfuras does not need to be updated
    }

    @Override
    public boolean canUpdate(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }
}
