package ru.avalon.jdev_130;

public class WareHouse {
    private volatile int goodsCount = 0;

    private WareHouse(){
    }

    private static class WareHouseHolder {
        private static final WareHouse WARE_HOUSE_HOLDER = new WareHouse();
    }

    public static WareHouse getInstance() {
        return WareHouseHolder.WARE_HOUSE_HOLDER;
    }

    public synchronized void get(int count) {
        while ((goodsCount - count) < 1) {
            try {
                System.out.println("!!!! Товаров не хватает !!!!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goodsCount -= count;
        System.out.printf("<---------------Покупатель купил %d товаров\n", count);
        System.out.println("Товаров на складе: " + goodsCount);
        notifyAll();
    }

    public synchronized void add(int count) {
        while ((goodsCount + count) > 10) {
            try {
                System.out.println("~~~~~~ Склад забит ~~~~~~");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goodsCount += count;
        System.out.printf("Производитель добавил %d товаров --------------->\n", count);
        System.out.println("Товаров на складе: " + goodsCount);
        notifyAll();
    }
}
