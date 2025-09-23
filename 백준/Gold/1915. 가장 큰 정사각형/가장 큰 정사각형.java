import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] dp;
    static boolean[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M+1];
        map = new boolean[N+1][M+1];

        for(int i = 1; i<=N; i++) {
            String line = br.readLine();
            for(int j = 1; j<=line.length(); j++) {
                map[i][j] = line.charAt(j-1) == '1';
            }
        }

        for(int i = 1; i<=N; i++) {
            for(int j=1 ;j<=M; j++) {
                if(!map[i][j]) continue;
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer*answer);

    }
}
