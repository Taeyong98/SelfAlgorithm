import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        for(int t = 0; t < T ; t++){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }
        br.close();
        bw.close();
    }
}
