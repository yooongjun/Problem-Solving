package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 힙 정렬

/**
 * heap_sort(A[1..n]) { # A[1..n]을 정렬한다.
 *     build_min_heap(A, n);
 *     for i <- n downto 2 {
 *         A[1] <-> A[i];  # 원소 교환
 *         heapify(A, 1, i - 1);
 *     }
 * }
 *
 * build_min_heap(A[], n) {
 *     for i <- ⌊n / 2⌋ downto 1
 *         heapify(A, i, n)
 * }
 *
 * # A[k]를 루트로 하는 트리를 최소 힙 성질을 만족하도록 수정한다.
 * # A[k]의 두 자식을 루트로 하는 서브 트리는 최소 힙 성질을 만족하고 있다.
 * # n은 배열 A의 전체 크기이며 최대 인덱스를 나타낸다.
 * heapify(A[], k, n) {
 *     left <- 2k; right <- 2k + 1;
 *     if (right ≤ n) then {
 *         if (A[left] < A[right]) then smaller <- left;
 *                                 else smaller <- right;
 *     }
 *     else if (left ≤ n) then smaller <- left;
 *     else return;
 *
 *     # 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
 *     if (A[smaller] < A[k]) then {
 *         A[k] <-> A[smaller];
 *         heapify(A, smaller, n);
 *     }
 * }
 *
 */
public class BOJ24173 {

    static int N;
    static int K;
    static int A[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        A = new int[N + 1];

        s = bufferedReader.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(s[i - 1]);
        }

        heap_sort(A);

        for (int i = 1; i <= N; i++) {
            System.out.println(A[i]);
        }
    }

    static void heap_sort(int A[]) {

        build_min_heap(A, N);

        for (int i = N; i >= 2; i--) {
            int tmp = A[1];
            A[1] = A[i];
            A[i] = tmp;
            heapify(A, 1, i-1);
        }
    }

    static void build_min_heap(int A[], int N) {
        for (int i = N / 2; i >= 1; i--) {
            heapify(A, i, N);
        }
    }

    static void heapify(int A[], int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller = 0;

        // 노드 K에서 왼쪽, 오른쪽 자식 노드 중 작은 노드와 바꾸기 위해 작은 노드를 선택하는 부분
        if (right <= n) {
            if (A[left] < A[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        // 노드 K의 값과 노드 smaller의 값을 비교해서 k가 더 크면 바꾼다!
        if (A[smaller] < A[K]) {
            int tmp = A[K];
            A[k] = A[smaller];
            A[smaller] = tmp;
            heapify(A, smaller, n);
        }
    }

}
