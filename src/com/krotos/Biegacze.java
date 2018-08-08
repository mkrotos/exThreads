package com.krotos;

class Biegacze {

    double z1 = 0;
    double z2 = 0;
    double z3 = 0;
    int meta = 10000;
    String[] pozycje = {"Pierwszy", "Drugi", "Trzeci"};
    int licznik = 0;
    String wynikZ1 = "";
    String wynikZ2 = "";
    String wynikZ3 = "";


    Runnable run1 = new Runnable() {
        public void run() {
            while (z1 < meta) {
     /* try{
        Thread.sleep(100);
      }catch(InterruptedException e){
        e.printStackTrace();
      }*/
                z1 += 0.0005;
            }
            wynikZ1 = pozycje[licznik];
            licznik++;
        }
    };
    Thread th1 = new Thread(run1);

    Runnable run2 = new Runnable() {
        public void run() {
            while (z2 < meta) {
     /* try{
        Thread.sleep(100);
      }catch(InterruptedException e){
        e.printStackTrace();
      }*/
                z2 += 0.0005;
            }
            wynikZ2 = pozycje[licznik];
            licznik++;
        }
    };
    Thread th2 = new Thread(run2);

    Runnable run3 = new Runnable() {
        public void run() {
            while (z3 < meta) {
      /*try{
        Thread.sleep(100);
      }catch(InterruptedException e){
        e.printStackTrace();
      }*/
                z3 += 0.0005;
            }
            wynikZ3 = pozycje[licznik];
            licznik++;
        }
    };
    Thread th3 = new Thread(run3);

    Runnable runPrint = new Runnable() {
        public void run() {
            while (z1 < meta || z2 < meta || z3 < meta) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (z1 < meta || z2 < meta || z3 < meta) {
                    disp1();
                } else {
                    disp2();
                }

            }
        }
    };
    Thread thPr = new Thread(runPrint);

    public void start() {
        th1.start();
        th2.start();
        th3.start();
        thPr.start();
    }


    private int[] sort(int... tab) {        //zle bo gubi nazwy biegaczy
        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab.length - 1; j++) {
                if (tab[j] > tab[j + 1]) {
                    int temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                }
            }
        }
        return tab;
    }

    private void disp1() {                    //prymitywnie, ale dziala

        if (z1 > z2 && z1 > z3) {
            System.out.println("1: biegacz z1: " + z1 + "m");
            if (z2 > z3) {
                System.out.println("2: biegacz z2: " + z2 + "m");
                System.out.println("3: biegacz z3: " + z3 + "m");
            } else {
                System.out.println("2: biegacz z3: " + z3 + "m");
                System.out.println("3: biegacz z2: " + z2 + "m");
            }

        } else if (z2 > z1 && z2 > z3) {
            System.out.println("1: biegacz z2: " + z2 + "m");
            if (z1 > z3) {
                System.out.println("2: biegacz z1: " + z1 + "m");
                System.out.println("3: biegacz z3: " + z3 + "m");
            } else {
                System.out.println("2: biegacz z3: " + z3 + "m");
                System.out.println("3: biegacz z1: " + z1 + "m");
            }
        } else {
            System.out.println("1: biegacz z3: " + z3 + "m");
            if (z1 > z2) {
                System.out.println("2: biegacz z1: " + z1 + "m");
                System.out.println("3: biegacz z2: " + z2 + "m");
            } else {
                System.out.println("2: biegacz z2: " + z2 + "m");
                System.out.println("3: biegacz z1: " + z1 + "m");
            }
        }
        System.out.println("------------------------------");
    }

    private void disp2() {
        System.out.println("Z1: " + wynikZ1);
        System.out.println("Z2: " + wynikZ2);
        System.out.println("Z3: " + wynikZ3);

    }
}
