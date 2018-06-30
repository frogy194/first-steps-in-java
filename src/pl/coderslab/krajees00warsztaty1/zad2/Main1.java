package pl.coderslab.krajees00warsztaty1.zad2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadz 6 roznych liczb z zakresu 1 - 49");
        int number;
        int[] arr = new int[6];
        for (int i = 0; i < 6;i++) {
            number = getNumber();
            while (arr[0] == number || arr[1] == number || arr[2] == number || arr[3] == number || arr[4] == number || arr[5] == number) {
                System.out.println("Podana liczba byla juz wprowadzona, podaj inna ");
                number = getNumber();
            }
//            for (int k : arr) {                                                        Nie mam pomyslu jak to while zmienić :/
//                if (number == k) {
//                        System.out.println("Podana liczba byla juz wprowadzona, podaj inna ");
//                        number = getNumber();
//                    }
//            }
            arr[i] = number;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] los = new Integer[49];
        for (int i = 0; i < los.length; i++) {
            los[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(los));

        int[] win = new int[6];
        for (int i = 0; i < 6; i++) {
            win[i] = los[i];
        }
        Arrays.sort(win);
        System.out.println(Arrays.toString(win));
        int hit = 0 ;
        for (int i : arr) {
            for (int j : win) {
                if (i == j) {
                    hit ++;
                }
            }
        }
        if (hit > 3) {
            System.out.println("Trafiłeś " + hit + " liczb!");
        }
    }


    static int getNumber() {
        Scanner scan = new Scanner(System.in);
        String shot = scan.next();
        while (!isNumeric(shot)) {
            System.out.println("To nie jest liczba");
            shot = scan.next();
        }
        int number = Integer.parseInt(shot);
        if ((number < 0) || (number > 49)) {
            System.out.println("Liczba nie miesci sie w przedziale 1-49");
            return getNumber();
        }
        return number;

    }


    public static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
