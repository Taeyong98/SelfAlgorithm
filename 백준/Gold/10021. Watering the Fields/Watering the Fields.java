
import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int getDist(int[] farm1, int[] farm2){
        int x1 = farm1[0];
        int y1 = farm1[1];
        int x2 = farm2[0];
        int y2 = farm2[1];
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int[][] map = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[i][0] = x;
            map[i][1] = y;
        }
        for(int i = 1; i< N; i++){
            int dist = getDist(map[0], map[i]);
            if(dist < C) continue;
            pq.add(new int[] {i, dist});
        }
        int count = 0;
        int total = 0;
        boolean[] visited = new boolean[N];
        visited[0] = true;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int index = temp[0];
            if(visited[index]) continue;
            visited[index] = true;
            total+= temp[1];
            count ++;
            for(int i = 0; i< N; i++){
                if(visited[i]) continue;
                int dist = getDist(map[index], map[i]);
                if(dist < C) continue;
                pq.add(new int[] {i, dist});
            }
        }
        if(count != N-1) System.out.println(-1);
        else System.out.println(total);
    }
}
