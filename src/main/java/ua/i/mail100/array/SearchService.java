package ua.i.mail100.array;

public class SearchService {
    public static int linear(int[] array, int criteria) {
        int size = array.length;

        for (int i = 0; i <size; i++)
              if (array[i] == criteria) {
                   return  i;
                }
       return -1;
    }
}
