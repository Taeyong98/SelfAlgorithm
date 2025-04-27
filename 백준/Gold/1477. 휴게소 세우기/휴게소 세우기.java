import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int L;
    static int[] arr;
    static int[] distArr;

    static boolean isPossible(int num){
        int count = 0;
        for(int i = 0; i<= N; i++){
            if(distArr[i]%num ==0){
                count += distArr[i]/num -1;
            }
            else{
                count += distArr[i]/num;
            }
        }
        return count <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr  = new int[N+2];
        distArr = new int[N+1];
        arr[0] = 0;
        arr[N+1] = L;
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 1; i<= N+1 ; i++){
            distArr[i-1] = arr[i] - arr[i-1];
        }
        int left = 1;
        int right = L;
        int answer = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(isPossible(mid)){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}
