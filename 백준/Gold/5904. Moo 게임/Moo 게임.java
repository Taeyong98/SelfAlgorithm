import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;

    public static char recursive(long index, int level){
        if(level == 0){
            if(index == 1){
                return 'm';
            }else{
                return 'o';
            }
        }
        if(index <= dp[level-1]){
            return recursive(index, level-1);
        }else if(index <= dp[level-1] + level+3){
            if(index == dp[level-1] +1){
                return 'm';
            }else {
                return 'o';
            }
        }else{
            return recursive(index-dp[level-1] - 3 - level, level-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[100];
        int count = 3;
        int maxS =0;
        dp[maxS] = 3;
        while(count < N){
            dp[maxS] = count;
            maxS++;
            count = count*2 + 3+maxS;
        }

        System.out.println(recursive(N, maxS));

    }
}
