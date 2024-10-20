import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long combination(long n) {
        return n*(n-1)/2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] remainArr = new int[M];
        remainArr[0] = 1;
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            count = (count+n)%M;
            remainArr[count] ++;
        }

        long answer =0;
        for(int j = 0; j<M;j++){
            if(remainArr[j]>1) {
                answer += combination(remainArr[j]);
            }
        }
        System.out.println(answer);
    }
}
