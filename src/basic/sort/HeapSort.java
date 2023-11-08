package basic.sort;

public class HeapSort {

    public static int[] heapSort(int[] target) {
        int arr[] = new int[target.length];

        Heap maxHeap = new Heap();

        for (int i = 0; i < target.length; i++) {
            maxHeap.add(target[i]);
        }

        for (int i = 0; i < target.length; i++) {
            arr[i] = maxHeap.delete();
        }

        return arr;
    }

    static class Heap{

        // 100000개의 노드를 가질 수 있는 트리
        int tree[] = new int[100001];
        int size = 0;

        public void add(int n) {
            int idx = size + 1;

            if (idx <= 100000) {
                tree[idx] = n;

                while (idx >= 1 && tree[idx] > tree[idx / 2]) {
                    int tmp = tree[idx];
                    tree[idx] = tree[idx / 2];
                    tree[idx / 2] = tree[idx];
                    idx /= 2;
                }

                size++;
            }
        }

        public int delete() {
            int idx = size + 1;
            int value = -1;

            if (size < 1) {
                return -1;
            }

            value = tree[1];
            tree[1] = tree[idx];
            idx = 1;
            size--;

            while (idx * 2  < size) {
                int left = tree[idx * 2];
                int right = tree[idx * 2 + 1];
                int tmp;

                if (tree[idx] >= left && tree[idx] >= right) {
                    break;
                }

                if (left > right) {
                    tmp = left;
                    tree[idx * 2] = tree[idx];
                    tree[idx] = tmp;
                    idx = idx * 2;
                }
                else {
                    tmp = right;
                    tree[idx * 2 + 1] = tree[idx];
                    tree[idx] = tmp;
                    idx = idx * 2 + 1;
                }

            }




            return value;
        }


    }


}
