
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[10001];

        for(int i =0; i<N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;

        for(int i = 0; i<N ; i++) {
            for(int j =arr[i]; j<=10000; j++){
                dp[j] += dp[j-arr[i]];
            }
        }

        System.out.println(dp[K]);

    }
}
