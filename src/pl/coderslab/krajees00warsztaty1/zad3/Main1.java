package pl.coderslab.krajees00warsztaty1.zad3;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pomyśl liczbe od 0 do 1000, a ja zgadnę ją w max 10 próbach");
        System.out.println("Zapisz ją sobie na kartce poniżej ( Nie bede podgladal ;) )");
        System.out.println("┌----------------------┐");
        System.out.print("|        ");
        scan.next();
        System.out.println("└----------------------┘" + "\n" + "Nie zapomnij używać poprawnych sformułowań : trafiłeś, mniej, więcej");
                int max = 1000, min = 0, guess = ((max - min) / 2), num = 1;
        System.out.println("Próba " + num + " Czy twoja liczba to " + guess);
        String anwser = scan.next();

        while (!anwser.equals("trafiłeś")) {
            num++;
            if (anwser.equals(("mniej"))) {
                max = guess;
                guess -= ((max - min) / 2 );
            } else if (anwser.equals("więcej")) {
                min = guess;
                guess += ((max - min) / 2 );
            } else {
                System.out.println("Nie oszukuj !");
                num--;
            }
            System.out.println("Próba " + num + " Czy twoja liczba to " + guess);
            anwser = scan.next();
        }
        System.out.println("Jestem najlepszy");
    }
}
