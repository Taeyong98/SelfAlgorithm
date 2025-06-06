import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int[] dp = new int[n+1];
        for(int i = 0; i<= n; i++) dp[i]= i;
        for(int i = 1 ; i<= n; i++){
            for(int j = 1 ; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[n]);

    }
}
