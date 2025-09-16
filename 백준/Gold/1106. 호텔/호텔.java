
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;

    static int[][] costArr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        costArr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            costArr[i][0] = c;
            costArr[i][1] = p;
        }

        dp = new int[C+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i <= C; i++){
            for(int j = 0; j<N; j++) {
                int c = costArr[j][1];
                int p = costArr[j][0];

                int prev = Math.max(0, i -p);   // 오버슈트 허용
                dp[i] = Math.min(dp[i], dp[prev] + c);
            }
        }

        System.out.println(dp[C]);
    }
}
