import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());

            // dp[a][b]: a층 b호
            int[][] dp = new int[k + 1][n + 1];

            // 0층 초기화
            for (int i = 1; i <= n; i++) dp[0][i] = i;

            // 1호는 모두 1
            for (int a = 0; a <= k; a++) dp[a][1] = 1;

            for (int a = 1; a <= k; a++) {
                for (int b = 2; b <= n; b++) {
                    dp[a][b] = dp[a][b - 1] + dp[a - 1][b];
                }
            }
            out.append(dp[k][n]).append('\n');
        }

        System.out.print(out);
    }
}
