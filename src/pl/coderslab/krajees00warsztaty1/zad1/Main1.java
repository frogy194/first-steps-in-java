package pl.coderslab.krajees00warsztaty1.zad1;

import com.sun.deploy.util.StringUtils;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        int rand = r.nextInt(100)+1;
        System.out.print("Zgadnij liczbę : ");

        int shoti = getNumber();
        for (;shoti != rand;) {
            if (shoti < rand) {
                System.out.println("Za mało!");
            } else {
                System.out.println("Za dużo!");
            }
            shoti = getNumber();
        }
        System.out.println("Zgadłeś !");


    }
    static int getNumber() {
        Scanner scan = new Scanner(System.in);
        String shot = scan.next();
        while (!isNumeric(shot)) {
            System.out.println("To nie jest liczba");
            shot = scan.next();
        }
        int number = Integer.parseInt(shot);
        return number;

    }
    static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}