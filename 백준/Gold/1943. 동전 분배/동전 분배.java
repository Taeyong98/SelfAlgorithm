import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] val = new int[N];
            int[] cnt = new int[N];

            int total = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                val[i] = Integer.parseInt(st.nextToken()); 
                cnt[i] = Integer.parseInt(st.nextToken()); 
                total += val[i] * cnt[i];
            }

            if ((total & 1) == 1) {        
                sb.append("0\n");
                continue;                  
            }

            int target = total / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int i = 0; i < N; i++) {
                int v = val[i];
                int c = cnt[i];

                for (int k = 1; c > 0; k <<= 1) {
                    int take = Math.min(k, c);
                    int w = v * take;                
                    for (int s = target; s >= w; s--)
                        dp[s] |= dp[s - w];
                    c -= take;
                }
            }

            sb.append(dp[target] ? "1\n" : "0\n");
        }

        System.out.print(sb.toString());
    }
}
