

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;

    static int[] candyArr;
    static boolean[] visited;

    static int[][] dp;
    static Map<Integer, List<Integer>> map;

    public static int[] bfs(int now){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(now);
        int candyCount = 0;
        int count = 0;

        if(!map.containsKey(now)){
            visited[now] = true;
            return new int[] {1, candyArr[now]};
        }
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();
            if(visited[node]) continue;
            visited[node] = true;
            candyCount += candyArr[node];
            count ++;
            List<Integer> nextList = map.get(node);
            for(Integer next : nextList) {
                if(!visited[next]){
                    queue.addLast(next);
                }
            }
        }

        return new int[] {count, candyCount};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        candyArr = new int[N+1];
        visited = new boolean[N+1];
        map = new HashMap<>();

        st= new StringTokenizer(br.readLine());
        for(int i =1 ; i<= N; i++){
            candyArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            List<Integer> listX = map.getOrDefault(x, new ArrayList<>());
            listX.add(y);

            List<Integer> listY = map.getOrDefault(y, new ArrayList<>());
            listY.add(x);
            map.put(x, listX);
            map.put(y, listY);
        }
        List<int[]> groupList = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            if(visited[i]){
                continue;
            }
            int[] temp = bfs(i);
            groupList.add(temp);
        }

        dp = new int[K][groupList.size()+1];
        for(int i = 1; i <= groupList.size(); i++) {
            int[] temp = groupList.get(i-1);
            int children = temp[0];
            int candies = temp[1];
            for(int j = 0 ; j<K ;j++) {
                dp[j][i] = dp[j][i-1]; // 이월 먼저
                if (j >= children) {
                    dp[j][i] = Math.max(dp[j][i], dp[j - children][i-1] + candies);
                }
            }
        }

        bw.write(dp[K-1][groupList.size()]+ "");
        bw.close();
        br.close();
    }
}
