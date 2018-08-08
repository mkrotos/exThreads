package com.krotos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;


class Main {
    public static void main(String[] args) {

        argsy("asDA", "Cos tam", "I to tez");
        Pair<Integer, String> pair = new Pair<>(5, "piec");
        pair.swap();
        System.out.println(pair.toString());

        //Pair2<Integer> pair2=new Pair2<>(23,65);
        //pair2.swap();

        Integer[] tabI = {123, 312, 345, 3, 34, 5545, 102, 13, 10, 3};
        Optional<Integer> zad1 = Arrays.asList(tabI).stream().filter(l -> l > 100 && l < 115).findFirst();
        //System.out.println("opt: "+zad1);
        zad1.ifPresent(System.out::println);
        if (!zad1.isPresent()) {
            System.out.println("Nie ma");
        }

        List<Person> listOfPer = new ArrayList<>();
        listOfPer.add(new Person("Adam", "Kokosz", 52));
        listOfPer.add(new Person("Kamil", "Włodarczyk", 27));
        listOfPer.add(new Person("Zuzanna", "Uwial", 14));
        listOfPer.add(new Person("Dawid", "Kichon", 35));
        listOfPer.add(new Person("Justyna", "Opus", 72));
        String cos = "cos";
        System.out.println("max wiek MK: " + maxWiekMK(listOfPer));

        Map<Character, String> map = new Map<>();
        map.put('a', "pierwszy");
        map.put('b', "drugi");
        map.put('c', "trzeci");
        map.put('d', "czwarty");
        map.disp();
        map.get('c');
        System.out.println("Jeszcze raz: " + map.get('d'));

        boolean removed = map.remove('b');
        System.out.println("Usunieto? " + removed);
        map.disp();
        map.put('d', "czwarty");

        Run run = new Run();
        //run.start();

        MojThread mojTh = new MojThread();
        // mojTh.poczatek();

        Biegacze biegacze = new Biegacze();
        biegacze.start();

    }

    public static void argsy(String... words) {
        for (int i = 0; i < words.length; i++) {
            System.out.println(i + ": " + words[i]);
        }
    }

    private static int maxWiekMK(List<Person> list) {
        return list.stream().filter(p -> p.name.startsWith("M") && p.surname.startsWith("K")).mapToInt(p -> p.age).max().orElse(-1);
    }

    public static class MojThread extends Thread {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        private void listIn() {
            for (int i = 0; i < 4; i++) {
                System.out.println("Wpis: ");
                list.add(scanner.nextLine());
            }
        }

        public void run() {
            while (list.size() < 4) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(list);
            }
        }

        public void poczatek() {
            start();
            listIn();
        }
    }
}
