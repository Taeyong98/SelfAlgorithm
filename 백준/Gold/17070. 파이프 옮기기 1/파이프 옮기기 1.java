
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        dp = new int[N+1][N+1][3];
        for(int i = 1; i<=N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=N ; j++){
                if(Objects.equals(st.nextToken(), "1")) map[i][j] = true;
            }
        }

        dp[1][2][0]=1;

        for(int i =1; i<=N ;i++){
            for(int j =1; j<=N; j++){
                if(i == 1 && j==2) continue;
                if(map[i][j]){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                    dp[i][j][2] = 0;
                    continue;
                }

                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
                if(map[i][j-1] || map[i-1][j]) dp[i][j][1] = 0;
            }
        }

//        for(int i =1; i<=N; i++){
//            for(int j =1; j<=N ;j++){
//                System.out.print(dp[i][j][0] + "," + dp[i][j][1] + "," + dp[i][j][2] +"|");
//            }
//            System.out.println();
//        }
        int answer = 0;
        answer = dp[N][N][0]+ dp[N][N][1]+ dp[N][N][2];
        System.out.println(answer);
    }
}
