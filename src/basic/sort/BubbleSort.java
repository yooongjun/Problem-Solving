package basic.sort;

public class BubbleSort {

    public static int[] bubbleSort(int[] target) {
        int[] arr = target.clone();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        return arr;
    }


}
