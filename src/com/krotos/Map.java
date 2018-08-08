package com.krotos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Map<T, K> {

    private List<T> keys = new ArrayList<>();
    private List<K> values = new ArrayList<>();

    public void put(T key, K value) {
        Integer index = findIndex(key);
        if (index != null) {
            System.out.println("Juz jest taki klucz");
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public void disp() {
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(i + ": " + keys.get(i) + "->" + values.get(i));
        }
    }

    public Optional<K> get(T key) {
        Integer index = findIndex(key);

        if (index == null) {
            System.out.println("Nie ma");
        }
        return Optional.ofNullable(values.get(index));
    }

    public boolean remove(T key) {
        Integer index = findIndex(key);
        if (index == null) {
            System.out.println("index null");
            return false;
        }
        T k = keys.remove((int) index);
        K v = values.remove((int) index);
        if (k != null && v != null) {
            return true;
        }
        return false;
    }

    private Integer findIndex(T key) {
        Integer index = null;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).equals(key)) {
                //System.out.println("Find: "+values.get(i));
                index = i;
                break;
            }
        }
        return index;
    }

}
