import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] map;
    static boolean[][] visited;

    static int answer = 0;
    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {x, y, 0});
        visited = new boolean[N][M];
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            int nowX = temp[0];
            int nowY = temp[1];
            int time = temp[2];
            answer = Math.max(answer, time);

            for(int d = 0; d<4; d++) {
                int newX = nowX+dx[d];
                int newY = nowY+dy[d];

                if(newX < 0 || newX >=N || newY <0 || newY>=M) continue;
                if(!map[newX][newY]) continue;
                if(visited[newX][newY]) continue;

                visited[newX][newY] = true;
                queue.addLast(new int[] {newX, newY, time+1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for(int i =0 ; i< N; i++) {
            String line = br.readLine();
            for(int j = 0; j<line.length();j++) {
                if(line.charAt(j)=='L') map[i][j] =true;
            }
        }

        for(int i =0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]) bfs(i,j);
            }
        }

        System.out.println(answer);

    }
}
