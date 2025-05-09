import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] arr;
    static int N;
    static boolean[][] dp1;
    static int[] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        N = arr.length;
        dp1 = new boolean[N][N];
        dp2 = new int[N];

        for(int i = 0 ; i<N; i++){ // dp1 배열 초기화
            dp2[i] = i+1; // dp2 배열 최악의 경우 팰린드롬 분할 길이로 초기화
            if(i == N-1){
                dp1[i][i] = true;
                break;
            }
            dp1[i][i] = true;
            if(arr[i] == arr[i+1]) dp1[i][i+1] = true;
        }

        for(int len = 2 ; len < N ; len++){ // start ~ start+len 이 팰린드롬인지 확인하는 DP
            for(int start = 0; start+len<N; start++){
                dp1[start][start+len] = (arr[start] == arr[start+len] && dp1[start+1][start+len-1]);
            }
        }



        for(int i = 0; i<N; i++){
            for(int j = 0; j<=i; j++){
              if(dp1[j][i]){// 팰린드롬이면?
                  if(j==0) dp2[i] = 1;
                  else{
                      dp2[i] = Math.min(dp2[i], dp2[j-1] + 1);
                  }
              }
            }
        }

        System.out.println(dp2[N-1]);

    }
}
