package ru.avalon.jdev_130;

public class Producer implements Runnable {
    private final WareHouse wareHouse = WareHouse.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int count = (int) (Math.random() * 3) + 1;
            wareHouse.add(count);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
