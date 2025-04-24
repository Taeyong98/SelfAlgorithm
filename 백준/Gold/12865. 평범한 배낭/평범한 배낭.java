import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] dp;
    static int[] weightArr;
    static int[] valueArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];
        weightArr = new int[N];
        valueArr = new int[N];
        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());
            weightArr[i] = Integer.parseInt(st.nextToken());
            valueArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i< N;i++){
            for(int j = K; j>=weightArr[i] ; j--){
                dp[j] = Math.max(dp[j], dp[j-weightArr[i]] + valueArr[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
