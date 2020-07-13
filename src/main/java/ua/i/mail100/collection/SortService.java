package ua.i.mail100.collection;

public class SortService {
    public static void buble(int[] array) {
        int size = array.length;

        for (int i = size-1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        for (int each : array) {
            System.out.println(each + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 5, 7, 4, -90, -9000, 0 };
        buble(array);
    }
}
