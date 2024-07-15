import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int N;

    static int[][] arr;
    static boolean[] visited;
    static void backtrack(int hand, int count){
        if(hand == N){
            answer = Math.max(count, answer);
            return;
        }
        if(arr[hand][0] <=0 || count == N-1){
            backtrack(hand+1, count);
            return;
        }
        int temp_count = count;
        for(int i =0; i<N; i++){
            if(i==hand || arr[i][0]<=0){
                continue;
            }
            arr[hand][0] -= arr[i][1];
            arr[i][0] -= arr[hand][1];
            if(arr[i][0]<=0){
                count++;
            }
            if(arr[hand][0]<=0){
                count++;
            }
            backtrack(hand+1,count);
            arr[hand][0] += arr[i][1];
            arr[i][0] += arr[hand][1];
            count = temp_count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        answer = 0;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 내구도
            arr[i][1] = Integer.parseInt(st.nextToken()); // 무게
        }
        backtrack(0,0);
        System.out.println(answer);

    }
}
