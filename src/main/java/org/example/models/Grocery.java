package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        boolean devam = true;

        while (devam) {
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");

            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 0:
                    devam = false;
                    break;

                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String eklenecekler = scanner.nextLine();
                    addItems(eklenecekler);
                    printSorted();
                    break;

                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String cikarilacaklar = scanner.nextLine();
                    removeItems(cikarilacaklar);
                    printSorted();
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (!checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();

            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}