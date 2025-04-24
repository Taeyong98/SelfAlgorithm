import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] memArr;
    static int[] costArr;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memArr = new int[N];
        costArr = new int[N];
        int maximumCost = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++){
            memArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++){
            costArr[i] = Integer.parseInt(st.nextToken());
            maximumCost += costArr[i];
        }
        dp = new int[maximumCost+1];
        for(int i = 0; i<N; i++){
            for(int j = maximumCost; j>=costArr[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-costArr[i]] + memArr[i]);
            }
        }
        int left = 0;
        int right = maximumCost;
        int answer = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(dp[mid]>=M){
                answer = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(answer);


    }
}
