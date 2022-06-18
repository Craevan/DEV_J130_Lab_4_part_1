package ru.avalon.jdev_130;

public class Main {
    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }
}
