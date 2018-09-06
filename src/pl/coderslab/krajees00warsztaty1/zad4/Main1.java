package pl.coderslab.krajees00warsztaty1.zad4;


import java.util.Arrays;
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(diceThrower("3D70+5")));
        System.out.println(Arrays.toString(diceThrower("2D40+5")));
    }

    private static int[] diceThrower(String factor) {
        Random r = new Random();
        int times, add = 0;
        String[] arr = factor.split("[^0-9]");

        if (!(factor.charAt(0) == 'D')) {
            times = Integer.parseInt(arr[0]);
        }
        else {
            times = 1;
        }

        int[] results = new int[times];
        int dice = Integer.parseInt(arr[1]);

        switch (arr.length) {

            case 3:
                if (factor.contains("+")) {
                add = Integer.parseInt(arr[2]);
                } else {
                    add = -(Integer.parseInt(arr[2]));

                }
                for (int i = 0; i < times; i++) {
                    results[i] = r.nextInt(dice) + 1 + add;
                }
                break;

            case 2:
                if (factor.contains("+")) {
                    add = Integer.parseInt(arr[2]);
                } else if (factor.contains("-")) {
                    add = -(Integer.parseInt(arr[2]));
                }
                for (int i = 0; i < times; i++) {
                        results[i] = r.nextInt(dice) + 1 + add;
                    }

                break;

            case 1:
                results[0] = r.nextInt(dice) + 1;
                break;
        }

        return results;
    }
}
