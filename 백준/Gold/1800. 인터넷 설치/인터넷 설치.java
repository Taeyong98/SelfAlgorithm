import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int P;
    static int K;

    static boolean[][] visited;

    static int[][] map;

    static boolean condition = false;

//    public static void dfs(int count, int node, int x){ //x 는 이분탐색의 기준 값
//        if(count>K) return;
//        if(node == N-1){
//            condition = true;
//            return;
//        }
//        for(int i =0 ; i< N; i++){
//            if(visited[i] || map[node][i] == 0) continue; // 방문했거나 이어지지 않았다면 continue;
//            visited[i] = true;
//            if(map[node][i] > x){
//                dfs(count+1, i, x);
//            }
//            else{
//                dfs(count, i ,x);
//            }
//            visited[i] = false;
//        }
//    }

    public static boolean dijkstra(int x){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[0]-o2[0]);
        pq.add(new int[] {0,0});
        visited = new boolean[N][K+1];
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int freeCount = temp[0];
            int node = temp[1];

            if(node == N-1) return true; // N-1 도착시 retur true;
            if(visited[node][freeCount]) continue;
            visited[node][freeCount] = true;
            for(int i = 0; i<N; i++){
                if(map[node][i] == 0) continue;
                if(map[node][i] <= x){
                    if(visited[i][freeCount]) continue;
                    pq.add(new int[] {freeCount, i});
                }
                else{
                    if(freeCount+1 >K || visited[i][freeCount+1]) continue;
                    pq.add(new int[] {freeCount+1, i});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int p = 0; p< P; p++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = dist;
            map[y-1][x-1] = dist;
        }

        int left = 0;
        int right = 1000000;
        int answer = -1;

        while(left <= right){
            int mid = (left+ right)/2;
//            dfs(0,0,mid);
            if(dijkstra(mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(answer);
    }
}
