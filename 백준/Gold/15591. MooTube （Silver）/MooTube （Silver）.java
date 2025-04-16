
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Q;

    static int count;

    public static void dfs(boolean[] visited, List<ArrayList<int[]>> list, int node, int minUsado, int K){
        visited[node] = true;
        for(int[] edge : list.get(node)){
            int nextNode = edge[0];
            int dist = edge[1];
            if(!visited[nextNode]){
                int newMin = Math.min(minUsado, dist);
                if(newMin >= K){
                    count++;
                    dfs(visited, list, nextNode,minUsado, K);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        List<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i =0 ; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            list.get(start-1).add(new int[] {end-1, usado});
            list.get(end-1).add(new int[] {start-1, usado});
        }

        for(int q = 0 ; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            count = 0;
            dfs(new boolean[N], list, node-1, Integer.MAX_VALUE, K);
            bw.write(count + "\n");
        }

        br.close();
        bw.close();
    }
}
//4 3
//1 2 3
//2 3 2
//2 4 4
//1 2
//4 1
//3 1