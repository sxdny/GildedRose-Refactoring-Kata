package com.gildedrose;

class GildedRose {

    // strings a constantes
    // eliminacion de magic numbers

    Item[] items;

    final int maxQuality = 50;
    final int maxQualitySulfuras = 80;
    final int tenDaysLeft = 10;
    final int fiveDaysLeft = 5;

    final String agedBrie = "Aged Brie";
    final String backstageToConcert = "Backstage passes to a TAFKAL80ETC concert";
    final String sulfuras = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals(agedBrie) && !items[i].name.equals(backstageToConcert)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(sulfuras)) {
                        items[i].quality--;
                    }
                }
            } else {
                if (items[i].quality < maxQuality) {
                    items[i].quality++;

                    if (items[i].name.equals(backstageToConcert)) {
                        if (items[i].sellIn <= tenDaysLeft) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality++;
                            }
                        }

                        if (items[i].sellIn <= fiveDaysLeft) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality++;
                            }
                        }
                    }
                }
            }
            if (items[i].name.equals(agedBrie)) {
                items[i].quality++;
                if (items[i].sellIn == 0) {
                    sellDatePassed(i, items);
                }
            }

            if (!items[i].name.equals(sulfuras)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(agedBrie)) {
                    if (!items[i].name.equals(backstageToConcert)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(sulfuras)) {
                                items[i].quality--;
                            }
                        }
                    } else {
                        items[i].quality--;
                    }
                } else {
                    if (items[i].quality < maxQuality) {
                        items[i].quality++;
                    }
                }
            }
        }
    }

    public void sellDatePassedAged(int i, Item[] items) {
        items[i].quality = items[i].quality + 2;
    }

    public void sellDatePassed(int i, Item[] items) {
        items[i].quality = items[i].quality - 2;
    }

    public String comprobarNombre(int i, Item[] items) {
        return items[i].name;
    }

    // siFechaRecomendadaVenta llega a 0
        // la calidad se degrada el doble de rapido
}