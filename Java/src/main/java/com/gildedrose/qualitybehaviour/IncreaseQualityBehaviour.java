package com.gildedrose.qualitybehaviour;

import com.gildedrose.Item;

public interface IncreaseQualityBehaviour {
    default void increaseQuality(Item item, int amount) {
        int currentQuality = item.quality;
        int newQuality = currentQuality + amount;
        item.quality = Math.min(newQuality, 50);
    }
}
