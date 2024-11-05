import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static StringBuilder sb;

    static void dfs(int depth, String str, int[] numArray){
        if(depth == M){
            sb.append(str).append("\n");
            return;
        }
        for(int i = 0; i<N;i++){
            dfs(depth+1, str+numArray[i]+" ", numArray);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] numArray = new int[N];
        for(int i = 0; i <N; i++){
            numArray[i] = i+1;
        }
        sb = new StringBuilder();
        dfs(0,"",numArray);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
