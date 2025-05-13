import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static int[] dist;
    static boolean[] visited;

    static List<int[]>[] map;

    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0]-o2[0]));
        pq.add(new int[] {0, start});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[1];
            int distance = cur[0];
            if(visited[nowNode]) continue;
            visited[nowNode] = true;
            dist[nowNode] = distance;

            for(int[] temp : map[nowNode]){
                if(visited[temp[0]]) continue;
                pq.add(new int[]{distance+temp[1], temp[0]});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new List[N+1];
        for(int i = 1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int s = Integer.parseInt(br.readLine());

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start].add(new int[] {end, cost});
        }

        dijkstra(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<=N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
