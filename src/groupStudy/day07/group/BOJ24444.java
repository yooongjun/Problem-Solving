package groupStudy.day07.group;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 알고리즘 수업 - 너비 우선 탐색 1
 */
public class BOJ24444 {

    private static int N, M, R;
    private static ArrayList<Integer>[] adjacentNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = bufferedReader.readLine().split(" ");

        // N, M, R 입력 받기
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        // 인접리스트 메모리 할당
        adjacentNodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacentNodes[i] = new ArrayList<>();
        }

        // 간선을 입력 받아 인접 리스트에 저장
        for (int i = 0; i < M; i++) {
            s = bufferedReader.readLine().split(" ");
            // node1과 node2의 간선 ( node1 <-> node2 )
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);

            // 인접 리스트에도 추가, 양방향이므로 양쪽에 다 추가합니다.
            adjacentNodes[node1].add(node2);
            adjacentNodes[node2].add(node1);
        }

        // 오름차순 방문을 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjacentNodes[i]);
        }

        // 인접리스트와 스타트 노드를 넘겨 bfs 시작
        int[] result = bfs(adjacentNodes, R);

        for (int i = 1; i < result.length; i++) {
            bufferedWriter.append(result[i] + "\n");
        }
        bufferedWriter.flush();
    }

    private static int[] bfs(ArrayList<Integer>[] adjacentNodes, int startNode) {
        // 방문 순서를 저장할 배열
        int order[] = new int[N + 1];
        int orderCnt = 1;

        boolean visit[] = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 방문처리
        visit[startNode] = true;
        queue.add(startNode);
        order[startNode] = orderCnt++;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            // 현재 꺼낸 노드의 인접 노드들 확인
            for (Integer i : adjacentNodes[cur]) {
                // 아직 방문하지 않은 경우 방문 처리, 방문 순서 저장 및 큐에 추가
                if (!visit[i]) {
                    visit[i] = true;
                    order[i] = orderCnt++;
                    queue.add(i);
                }
            }
        }

        return order;
    }


}
