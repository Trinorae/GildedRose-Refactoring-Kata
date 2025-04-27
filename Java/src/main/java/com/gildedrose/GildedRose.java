package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Item types:
    // 1. Normal item
    // 2. Aged Brie
    // 3. Sulfuras, Hand of Ragnaros
    // 4. Backstage passes to a TAFKAL80ETC concert
    // 5. Conjured items (to be added)

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // Not Aged Brie, not Backstage Passes -> Normal item
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    // And not Sulfuras -> Normal item only
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            // Only for Aged Brie and Backstage Passes
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    // Extra for Backstage Passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // Only for Normal items, Aged Brie and Backstage Passes -> sellIn of Sulfuras doesn't change ever!
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Normal Item (and Sulfuras)
                        if (items[i].quality > 0) {
                            // Not Sulfuras, so just Normal item
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    // Backstage Passes
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                // Aged Brie
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
