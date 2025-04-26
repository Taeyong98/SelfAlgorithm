import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;
    static int[] arr2;
    static int[] count;
    static int N;
    static int H;

    public static int upperBound1(int left, int right, int target){
        while(left < right){
            int mid = (left+right)/2;
            if(arr1[mid] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static int upperBound2(int left, int right, int target){
        while(left < right){
            int mid = (left+right)/2;
            if(arr2[mid] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr1 = new int[N/2];
        arr2 = new int[N/2];
        count = new int[N+1];
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(br.readLine());
            if (n % 2 == 0) { // 입력 순서 기준
                arr1[n/2] = num; // 석순
            } else {
                arr2[n/2] = num; // 종유석
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            int cnt = 0;
            cnt += (N/2 - upperBound1(0, N/2, i-1)); // 석순 (i 이상 부딪힘)
            cnt += (N/2 - upperBound2(0, N/2, H-i)); // 종유석 (H-i 이상 부딪힘)

            count[cnt]++;
            min = Math.min(min, cnt);
        }


        System.out.println(min + " " + count[min]);

    }
}
