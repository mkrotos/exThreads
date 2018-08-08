package com.krotos;

class Run {

    Runnable runnable1 = new Runnable() {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread th1 = new Thread(runnable1);

    Runnable runnable2 = new Runnable() {
        public void run() {
            for (int i = 10; i >= 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Thread th2 = new Thread(runnable2);


    public void start() {
        th1.start();
        th2.start();
    }


}
