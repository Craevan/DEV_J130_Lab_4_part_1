package ru.avalon.jdev_130;

public class Consumer implements Runnable {
    private final WareHouse wareHouse = WareHouse.getInstance();

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            int count = (int) (Math.random() * 5) + 1;
            wareHouse.get(count);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
