
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static void perm(int cnt, String str, boolean[] visited, int[] numArray){
        if(cnt == M){
            sb.append(str).append("\n");
            return;
        }
        for(int i = 0 ; i<N ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            perm(cnt+1, str+ numArray[i] + " ", visited, numArray);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] numArray = new int[N];
        sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            numArray[i] = i+1;
        }
        boolean[] visited = new boolean[N];
        perm(0,"",visited,numArray);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
