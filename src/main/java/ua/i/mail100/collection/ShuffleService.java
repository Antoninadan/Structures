package ua.i.mail100.collection;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleService {
    public static void shuffle(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        int[] two = {0, 1, 2, 3, 4, 5, 6};
        for (int each : two) {
            System.out.println(each);
        }
    }
}
