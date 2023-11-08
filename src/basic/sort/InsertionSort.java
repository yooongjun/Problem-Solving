package basic.sort;

public class InsertionSort {

    public static int[] insertionSort(int[] target) {
        int[] arr = target.clone();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            while (i - 1 >= 0 && key < arr[i - 1]) {
                arr[i] = arr[i - 1];
                arr[i - 1] = key;
                i--;
            }
        }
        return arr;
    }

}
