package basic.sort;

public class SelectionSort {

    public static int[] selectionSort(int[] target) {
        int min = 0;
        int arr[] = target.clone();

        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }

}
