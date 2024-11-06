import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[][] board;
    static boolean[][] visited;

    static int totalTomato;

    static Deque<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    static int bfs(){
        int answer = 0;
        int visitCount = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int x = temp[0];
            int y = temp[1];
            int depth = temp[2];
            visitCount++;
            answer = depth;
            for(int d = 0 ; d< 4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx >= 0 && nx <N && ny >= 0 && ny<M && !visited[nx][ny] && board[nx][ny] != -1){
                    visited[nx][ny] = true;
                    queue.addLast(new int[] {nx, ny, depth+1});
                }
            }
        }
        if(visitCount == totalTomato){
            return answer;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        totalTomato = N*M;
        queue = new ArrayDeque<>();

        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <M ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1){
                    totalTomato--;
                }
                if(board[i][j]==1){
                    visited[i][j] = true;
                    queue.addLast(new int[]{i, j ,0});
                }
            }
        }
        System.out.println(bfs());

    }
}
