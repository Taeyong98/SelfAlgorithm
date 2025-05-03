import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        for(int i = 1; i<= N+1; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i<=N){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int time = Integer.parseInt(st.nextToken());
                int pay = Integer.parseInt(st.nextToken());
                if(i+time > N+1) continue;
                dp[i+time] = Math.max(dp[i] + pay, dp[i+time]);
            }

        }
        System.out.println(dp[N+1]);
    }
}
