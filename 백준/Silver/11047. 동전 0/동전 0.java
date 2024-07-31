import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");
        int N = Integer.parseInt(lines[0]);
        int target = Integer.parseInt(lines[1]);
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        int answer = 0;
        for(int i = N-1; i>=0; i--){
            if(arr[i] > target) continue;
            int mok = target/arr[i];
            answer += mok;
            target -= mok*arr[i];
        }
        System.out.println(answer);
    }
}
