
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 만들 랜선 개수
    static int K; //랜선 개수
    static int[] lineArr; //랜선 배열

    public static boolean isPossible(long length){
        long count = 0;
        for(int k = 0 ; k< K; k++){
            count += lineArr[k]/length;
        }
        return count >= N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         K = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
        lineArr = new int[K];
        for(int k = 0 ; k < K; k++){ // 랜선 배열 초기화
            lineArr[k] = Integer.parseInt(br.readLine());
        }

        long left = 0;
        long right = Integer.MAX_VALUE;
        long answer = 0;
        while(left <= right){
            long mid = (left+right)/2;
            if(isPossible(mid)){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
