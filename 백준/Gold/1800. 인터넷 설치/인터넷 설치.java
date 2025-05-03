import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, P, K;
    static List<Edge>[] graph;

    public static boolean bfs(int maxCost) {
        int[] used = new int[N + 1]; // K 이하로 넘은 간선 수 저장
        Arrays.fill(used, Integer.MAX_VALUE);
        used[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // {현재 노드, 비싼 간선 수}

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0];
            int expensive = now[1];

            if (cur == N) return expensive <= K;

            for (Edge e : graph[cur]) {
                int nextExpensive = expensive + (e.cost > maxCost ? 1 : 0);
                if (nextExpensive < used[e.to]) {
                    used[e.to] = nextExpensive;
                    pq.offer(new int[]{e.to, nextExpensive});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        int maxEdgeCost = 0;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
            graph[v].add(new Edge(u, c));
            maxEdgeCost = Math.max(maxEdgeCost, c);
        }

        int left = 0, right = maxEdgeCost;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
