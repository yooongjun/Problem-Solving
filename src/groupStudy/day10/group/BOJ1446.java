package groupStudy.day10.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1446 {

    static int N, D;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        D = Integer.parseInt(s[1]);

        ArrayList<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            
            // 지름길이 도착지보다 멀리 있는 경우 다시 돌아올 수 없으므로 버림
            if(start > D || end > D) continue;

            shortcuts.add(new Shortcut(start, end, cost));
        }

        // 앞에서 나오는 지름길부터 조사하기 위해서 정렬
        Collections.sort(shortcuts, (s1, s2) -> s1.start - s2.start);

        int result = findShortestPath(shortcuts);

        System.out.println(result);
    }

    private static int findShortestPath(ArrayList<Shortcut> shortcuts) {

        // 최소 거리를 저장한 배열
        int distance[] = new int[D + 1];

        // 거리 배열을 초기화 :: 지름길없이 같을 때의 거리
        for (int i = 0; i < distance.length; i++) {
            distance[i] = i;
        }

        // 지름길을 앞에서부터 하나씩 반영하면서 최소 거리를 갱신함
        for (int i = 0; i < shortcuts.size(); i++) {
            // shortcut : 현재 보고 있는 지름길
            Shortcut shortcut = shortcuts.get(i);
                
            // 지름길의 도착지 값을 갱신하기
            distance[shortcut.end] = Math.min(distance[shortcut.start] + shortcut.cost, distance[shortcut.end]);
            
            // 지름길을 사용한 경우를 반영하여 목적지의 값을 갱신하기
            distance[D] = Math.min(distance[D], distance[shortcut.end] + D - shortcut.end);

            // 지름길의 시작점 기준으로 오름차순 정렬되어 있으므로 다음 지름길의 시작지까지의 값을 갱신
            for (int j = i + 1; j < shortcuts.size(); j++) {
                // nextShortcut :: 다음 지름길
                Shortcut nextShortcut = shortcuts.get(j);

                // 다음 지름길이 현재 지름길 끝나기 전에 시작한다면 쓸 수 없음
                if (nextShortcut.start < shortcut.end) {
                    continue;
                }

                // 다음 지름길의 시작지 값을 현재 지름길을 사용한 경우와 그렇지 않은 경우를 비교하여 갱신
                distance[nextShortcut.start] = Math.min(distance[nextShortcut.start] , distance[shortcut.end] + nextShortcut.start - shortcut.end);
            }
        }

        return distance[D];
    }


    static class Shortcut{

        int start;
        int end;
        int cost;

        public Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
