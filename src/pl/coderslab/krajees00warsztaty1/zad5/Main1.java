package pl.coderslab.krajees00warsztaty1.zad5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Arrays;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {

        String[] exclude = {"Wiadomości","oraz","ponieważ","tylko","dlatego","Warszawa"};
        words("http://onet.pl");
        words("http://demotywatory.pl");
        File file = new File("popular_words.txt");
        filtered(file,exclude);

    }

    private static void words(String site) {
        String all = "";
        Connection connect = Jsoup.connect(site);
        try {

            Document document = connect.get();
            Elements links = document.select("h1");


            PrintWriter out = new PrintWriter(new FileWriter("popular_words.txt",true));

            for (Element elem : links) {

                all += elem.text() + " ";
            }

            String[] arr = all.split(" ");

            for (int i = 0; i < arr.length; i++) {

                if ((arr[i].length() > 3) && arr[i].replaceAll("[^\\d.]", "").equals("")) {

                    out.println(arr[i].replaceAll(",", ""));

                }

            }

            out.close();
        }
                 catch (IOException e) {


                e.printStackTrace();

            }


    }

    private static void filtered(File file, String[] excluded) {
        String sc = "";

        try {

            PrintWriter out = new PrintWriter("filtered_popular_word.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                sc = scan.nextLine();

                if (!(Arrays.asList(excluded).contains(sc))) {

                    out.println(sc);

                }

            }

            out.close();

        } catch (IOException a) {
            a.printStackTrace();
        }

    }
}

