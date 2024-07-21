import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                System.out.println("1 0");
                continue;
            }else if(n==1){
                System.out.println("0 1");
                continue;
            }

            int[] dp = new int[n+1];
            dp[n] = 1;
            for(int i = n; i>=2;i--){
                dp[i-1] += dp[i];
                dp[i-2] += dp[i];
            }
            System.out.println(dp[0] + " " + dp[1]);
        }
        br.close();
    }
}
