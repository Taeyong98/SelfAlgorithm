import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;

    public static int[] dfs(int node){
        visited[node] = true;
        int normal = 0;
        int earlyAdapter = 1;
        for(Integer next : list[node]){
            if (visited[next]) continue;
            int[] temp = dfs(next);
            normal += temp[1]; 
            earlyAdapter += Math.min(temp[0], temp[1]); 
        }
        return new int[] {normal, earlyAdapter};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i<=N ;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start); // 양방향 추가!
        }

        int[] temp = dfs(1);
        System.out.println(Math.min(temp[0], temp[1]));
    }
}
