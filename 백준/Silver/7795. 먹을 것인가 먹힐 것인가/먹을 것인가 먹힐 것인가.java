import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;
            int[] arrN = new int[N];
            int[] arrM = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arrN[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                arrM[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrN);
            Arrays.sort(arrM);
            int MIndex = arrM.length-1;
            for(int i = arrN.length-1; i>=0; i--){
                while(MIndex!=-1&&arrN[i]<=arrM[MIndex]){
                    MIndex--;
                }
                answer += MIndex+1;
            }
            System.out.println(answer);
        }
        br.close();
    }
}
