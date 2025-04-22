import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static String str1;
    static String str2;
    static int N;
    static int M;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str1 = br.readLine();
        N = str1.length();
        str2 = br.readLine();
        M = str2.length();
        dp = new int[N+1][M+1];
        for(int i = 1; i<=N; i++){
            for(int j= 1; j<=M; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int row = N;
        int col = M;
        Deque<Character> deque = new ArrayDeque<>();
        while(row!=0 || col!=0){ // 역순으로 구하기
            if(row-1>=0 && col-1>=0 &&str1.charAt(row-1) == str2.charAt(col-1)){
                deque.addFirst(str1.charAt(row-1));
                row --;
                col --;
                continue;
            }
            if(row-1 >= 0 && dp[row-1][col] == dp[row][col]){
                row--;
                continue;
            }
            if(col-1>= 0 && dp[row][col-1] == dp[row][col]){
                col--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[N][M]).append("\n");
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
