import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static boolean[][] visited;
    static final int[] dx = {-2, -2, 2, 2 , -1, -1 ,1 ,1};
    static final int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    static int bfs(int x, int y, int fx, int fy){
        int answer = -1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{x, y, 0});
        visited[x][y] = true;
        while (!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            x = temp[0];
            y = temp[1];
            int depth = temp[2];
            if(x==fx && y == fy){
                answer = depth;
                break;
            }
            for(int d = 0; d<8; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.addLast(new int[]{nx,ny,depth+1});
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t =0 ; t<T ; t++){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int finX = Integer.parseInt(st.nextToken());
            int finY = Integer.parseInt(st.nextToken());
            System.out.println(bfs(startX,startY,finX,finY));
        }
    }
}
