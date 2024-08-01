package BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 인간 - 컴퓨터 상호작용
public class BOJ16139 {

    static String s;
    static int q;

    static int sum[][] = new int['z' - 'a' + 1][200001];

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = br.readLine();
        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < s.length(); i++) {

            sum[s.charAt(i)-'a'][i]++;

            if (i > 0) for (int j = 0; j < sum.length; j++) sum[j][i] += sum[j][i - 1];

        }


        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int find = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.append((l > 0 ? sum[find][r] - sum[find][l - 1] : sum[find][r]) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new BOJ16139().solution();
    }
}
