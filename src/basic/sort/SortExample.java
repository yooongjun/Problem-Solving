package basic.sort;

import java.util.Scanner;

public class SortExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] target = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        // 선택 정렬
        int[] selectionSortResult = SelectionSort.selectionSort(target);
        printArr("SelectionSort", selectionSortResult);

        // 삽입 정렬
        int[] insertionSortResult = InsertionSort.insertionSort(target);
        printArr("InsertionSort", insertionSortResult);

        // 버블 정렬
        int[] bubbleSortResult = BubbleSort.bubbleSort(target);
        printArr("BubbleSort", bubbleSortResult);

        // 힙 정렬
        int[] heapSortResult = HeapSort.heapSort(target);
        printArr("HeapSort", heapSortResult);

    }

    static void printArr(String sortType, int arr[]) {
        System.out.print(sortType + "'s Result : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
