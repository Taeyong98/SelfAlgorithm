import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static HashMap<Integer, Integer> redPortal;
    static HashMap<Integer, Integer> bluePortal;

    static int bfs(){
        int answer = -1;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        queue.offerLast(new int[] {0, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int node = cur[0];
            int time = cur[1];

            if(node == N-1){
                answer = time;
                break;
            }
            if(visited[node]) continue;
            visited[node] = true;
            if(redPortal.containsKey(node)){
                int next = redPortal.get(node);
                if(!visited[next]) queue.offerFirst(new int[] {next , time});
                continue;
            }
            if(bluePortal.containsKey(node)){
                int next = bluePortal.get(node);
                if(!visited[next]) queue.offerFirst(new int[] {next, time});
            }
            queue.offerLast(new int[] {node+1, time+1});
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        redPortal = new HashMap<>();
        bluePortal = new HashMap<>();

        for(int i = 0; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int portal = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(portal == 0){
                redPortal.put(start, end);
            }else{
                bluePortal.put(start, end);
            }
        }
        System.out.println(bfs());
    }
}
