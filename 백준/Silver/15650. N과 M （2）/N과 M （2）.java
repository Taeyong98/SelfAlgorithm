import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;

    public static int[] arr;

    public static void func (int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }
        for(int i =1; i<=N;i++){
            if(depth==0){
                arr[depth] = i;
                func(depth+1);
            }else{
                if(arr[depth-1] + i > N){
                    break;
                }
                arr[depth] = arr[depth-1] + i;
                func(depth+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        func(0);
    }

}
