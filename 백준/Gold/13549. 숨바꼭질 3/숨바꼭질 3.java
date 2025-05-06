import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    static boolean[] visited = new boolean[100001];

    static int bfs(){
        int answer = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int now = cur[0];
            int time = cur[1];
            if(now == K){
                answer= time;
                break;
            }
            if(visited[now]) continue;
            visited[now] = true;
            if(now*2<=100000 && !visited[now*2]){
                queue.addFirst(new int[] {now*2, time});
            }
            if(now+1 <= 100000 && !visited[now+1]){
                queue.addLast(new int[] {now+1, time+1});
            }
            if(now-1 >= 0 && !visited[now-1]){
                queue.addLast(new int[] {now-1, time+1});
            }
            

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());

    }
}
