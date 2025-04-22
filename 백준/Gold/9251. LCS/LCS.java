import java.io.*;

public class Main {
    static int N;
    static int M;

    static String str1;
    static String str2;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str1 = br.readLine();
        N = str1.length();
        str2 = br.readLine();
        M = str2.length();
        dp = new int[N+1][M+1];

        for(int i= 1; i<= N; i++){
            for(int j = 1; j<=M; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        bw.write(dp[N][M]+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
