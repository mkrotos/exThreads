package com.krotos;

class Pair<T, K> {

    T obiekt1;
    K obiekt2;

    public Pair(T obiekt1, K obiekt2) {
        this.obiekt1 = obiekt1;
        this.obiekt2 = obiekt2;
        System.out.println("Utworzono: " + toString());
    }


    public Pair<K, T> swap() {
        // T temp1=obiekt1;
        //  K temp2=obiekt2;

        //K obiekt1=obiekt2;
        //T obiekt2=temp1;
        // System.out.println(toString());
        return new Pair<K, T>(obiekt2, obiekt1);
    }

    public String toString() {
        return obiekt1 + ", " + obiekt2;
    }
}

