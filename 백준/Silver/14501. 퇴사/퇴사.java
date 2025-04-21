import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        int[] t = new int[N+1];
        int[] p = new int[N+1];
        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]); // 오늘까지의 최적값 반영
            if(i + t[i] <= N+1 ){  // 퇴사 전까지 상담 끝나야 함
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }
        System.out.println(Math.max(dp[N], dp[N+1]));
    }
}
