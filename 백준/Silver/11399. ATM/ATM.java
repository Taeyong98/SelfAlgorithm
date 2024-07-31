import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for(int i = 0; i < N; i ++){
             arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 1 ; i <= N; i++){
            answer += arr[i-1]*(N-i+1);
        }
        System.out.println(answer);
    }
}
