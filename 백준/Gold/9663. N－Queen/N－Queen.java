import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen
public class Main {
    public static int count = 0;
    public static int N;
    public static int[] map;

    public static void nQueen(int depth){
        if(depth == N){
            count ++;
            return;
        }
        for(int i =0; i<N; i++){
            map[depth] = i;
            if(check(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean check(int depth){
        boolean flag = true;
        for(int i = 0; i<depth; i++){
            if(map[i]==map[depth] || Math.abs(i-depth) == Math.abs(map[i]-map[depth])){
                flag =false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        nQueen(0);
        System.out.println(count);
    }
}
