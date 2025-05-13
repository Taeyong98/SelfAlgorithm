import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static List<int[]>[] map;

    static int[] dist;
    static boolean[] visited;

    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        pq.add(new int[] {0, start});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[1];
            int cost = cur[0];
            if(visited[node]) continue;
            visited[node] = true;
            dist[node] = cost;
            for(int[] temp : map[node]){
                int c = temp[1];
                int next = temp[0];
                if(visited[next]) continue;
                pq.add(new int[]{cost+c, next});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start].add(new int[] {end, cost});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dist[end]);

    }
}
