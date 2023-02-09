package BackJoon.IdxTree;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * 최솟값 찾기
 * L의 크기로 트리를 만들고 그 트리에 현재 숫자를 넣고 edit하여 찾음.
 * N개의 수를 edit함 --> O( NlogN )
 */
public class BOJ11003 {

    // 인덱스 트리
    static int firstLeaf = 1;
    static int idx[];

    static final int INF = Integer.MAX_VALUE;
    static int n, l;
    static int a[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        a = new int[n + 1];

        // 리프 노드 인덱스 찾기
        while(firstLeaf < l){
            firstLeaf *= 2;
        }
        
        // 트리 생성
        idx = new int[ firstLeaf * 2 ];
        
        // 트리의 값을 INF로 전부 초기화
        for(int i = 1; i < idx.length; i++){
            idx[i] = INF;
        }

        st = new StringTokenizer(br.readLine());
        int t;
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());

            // 노드 인덱스
            t = i % l;
            if(t == 0) t = l;

            bw.append(edit( t, a[i]) + " ");
        }

        bw.flush();
    }

    // x번째 leaf노드의 값을 value로 수정하고, 루트 노드의 값을 반환
    static int edit(int x, int value)
    {
        // 데이터 입력
        x = firstLeaf + x -1;
        idx[x] = value;

        // 트리 수정
        while (x > 1){
            x /= 2;
            idx[x] = Math.min(idx[x*2], idx[x*2 + 1]);
        }

        return idx[1];
    }




}
