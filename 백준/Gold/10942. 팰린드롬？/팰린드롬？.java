

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N= Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[N][N];

        for(int i = 0 ; i< N; i++){
            dp[i][i] = true;
        }
        for(int i =0; i<N-1; i++){

            if(arr[i] == arr[i+1]) dp[i][i+1] =true;

        }

        for (int len = 2; len < N; len++) {
            for (int start = 0; start + len < N; start++) {
                int end = start + len;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            if(dp[start][end]) bw.write("1\n");
            else bw.write("0\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
