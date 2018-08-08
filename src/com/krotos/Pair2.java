package com.krotos;

class Pair2<T> {

    T obiekt1;
    T obiekt2;

    public Pair2(T obiekt1, T obiekt2) {
        this.obiekt1 = obiekt1;
        this.obiekt2 = obiekt2;
        System.out.println("Utworzono: " + toString());
    }

    public String toString() {
        return obiekt1 + ", " + obiekt2;
    }

    public void swap() {
        T temp = obiekt1;
        obiekt1 = obiekt2;
        obiekt2 = temp;
        System.out.println(toString());
    }

}
