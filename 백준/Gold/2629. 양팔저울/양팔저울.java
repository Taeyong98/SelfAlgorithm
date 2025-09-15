import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean [][] dp;

    static int N;

    static int T;
    static int[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dp = new boolean[80001][N+1];

        weights = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = N; i>=1; i--) {
             weights[i] = Integer.parseInt(st.nextToken());
        }
        dp[40000][0] = true;

        for(int i = 1; i<= N; i++) {
            for(int j = 0 ; j <=80000 ; j++){
                if(j-weights[i] >= 0){
                    dp[j][i] = dp[j-weights[i]][i-1] || dp[j][i];
                }
                if(j+weights[i] <= 80000) {
                    dp[j][i] = dp[j+weights[i]][i-1] || dp[j][i];
                }
                dp[j][i] = dp[j][i-1] || dp[j][i];
            }
        }
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(dp[x+40000][N]) sb.append("Y").append(" ");
            else sb.append("N").append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
