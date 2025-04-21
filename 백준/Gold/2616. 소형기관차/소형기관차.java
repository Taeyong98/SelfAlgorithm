import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] prefixSum;

    static int K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prefixSum = new int[N+1];
        dp = new int[4][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + num;
        }
        K = Integer.parseInt(br.readLine());

        for(int i = 1; i<=3 ; i++){
            for(int j = 1; j<=N ; j++){
                if(j-K >= 0){
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-K] + prefixSum[j] - prefixSum[j-K]);
                }else{
                    dp[i][j] = prefixSum[j];
                }
            }
        }
        System.out.println(dp[3][N]);

    }
}
