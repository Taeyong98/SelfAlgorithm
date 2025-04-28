import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int N;

    static int[] nameCount = new int[21];

    static int[] name;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        name = new int[N];
        for(int i = 0 ; i<N; i++){
             name[i] = br.readLine().length();
        }
        for(int i =0; i<=K; i++){
            nameCount[name[i]]++;
        }

        long answer = 0;
        for(int i =0 ; i<N; i++){
            answer += --nameCount[name[i]];

            if(i+K+1 < N){
                nameCount[name[i+K+1]]++;
            }
        }

        System.out.println(answer);
    }
}
