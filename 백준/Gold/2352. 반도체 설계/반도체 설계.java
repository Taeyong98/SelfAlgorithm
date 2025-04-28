import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    static int binarySearch(int left, int right, int num){
        while(left<right){
            int mid = (left+right)/2;
            if(dp[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int len = 1;
        for(int i =1 ; i<N; i++){
            if(dp[len-1] < arr[i]){
                dp[len] = arr[i];
                len++;
            }else{
                int index = binarySearch(0, len-1 ,arr[i]);
                dp[index] = arr[i];
            }
        }
        System.out.println(len);
    }
}
