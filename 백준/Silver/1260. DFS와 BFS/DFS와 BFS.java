import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int startNode;

    static int[][] matrix;
    static boolean[] visited;

    static String dfs(int cnt, StringBuilder sb){
         sb.append(cnt).append(" ");
        visited[cnt] = true;
        for(int i = 1; i <= N; i++){
            if(matrix[cnt][i]==1 && !visited[i]) dfs(i,sb);
        }
        return sb.toString();
    }

    static String bfs(int cnt){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(cnt);
        visited[cnt] =true;
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()){
            cnt = queue.pollFirst();
            str.append(cnt).append(" ");
            for(int i = 1; i<=N; i++){
                if(matrix[cnt][i]==1&& !visited[i]){
                    visited[i] = true;
                    queue.addLast(i);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        //일단 인접행렬로 풀게요
        matrix = new int [N+1][N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }
        visited = new boolean[N+1];
        bw.write(dfs(startNode, new StringBuilder()));
        bw.write("\n");
        visited = new boolean[N+1];
        bw.write(bfs(startNode));
        bw.close();
        br.close();

    }
}
