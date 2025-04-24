import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] memArr;
    static int[] costArr;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memArr = new int[N];
        costArr = new int[N];
        int maximumCost = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++){
            memArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++){
            costArr[i] = Integer.parseInt(st.nextToken());
            maximumCost += costArr[i];
        }
        dp = new int[maximumCost+1];
        for(int i = 0; i<N; i++){
            for(int j = maximumCost; j>=costArr[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-costArr[i]] + memArr[i]);
            }
        }
        for (int i = 0; i <= maximumCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }

    }
}
