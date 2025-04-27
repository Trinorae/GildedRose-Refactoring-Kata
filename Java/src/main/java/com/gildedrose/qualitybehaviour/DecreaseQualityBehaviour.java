package com.gildedrose.qualitybehaviour;

import com.gildedrose.Item;

public interface DecreaseQualityBehaviour {
    default void decreaseQuality(Item item, int amount) {
        int currentQuality = item.quality;
        int newQuality = currentQuality - amount;
        item.quality = Math.max(newQuality, 0);
    }
}
