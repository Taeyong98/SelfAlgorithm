
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> pq;
    static int[][] dp;
    static int[][] map;

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 1;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int [N][N];

        pq = new PriorityQueue<>(((o1, o2) -> {
            return o2[0] - o1[0];
        }));

        map = new int[N][N];

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int bamboo = Integer.parseInt(st.nextToken());
                pq.add(new int[] {bamboo, i, j});
                map[i][j] = bamboo;
            }
        }

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int n = temp[0];
            int x = temp[1];
            int y = temp[2];
            dp[x][y] = Math.max(1, dp[x][y]);

            for(int d = 0; d<4; d++) {
                int newX = x+dx[d];
                int newY = y+dy[d];
                if(newX < 0 || newX >=N || newY <0 || newY>=N) continue;
                if(map[newX][newY] < n) {
                    dp[newX][newY] = Math.max(dp[x][y] + 1, dp[newX][newY]);
                    answer = Math.max(dp[newX][newY], answer);
                }
            }
        }
        System.out.println(answer);

    }
}
