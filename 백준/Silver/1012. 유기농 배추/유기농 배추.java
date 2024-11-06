import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void dfs(int x, int y){
        visited[x][y] =true;

        for(int d = 0 ; d < 4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && board[nx][ny] == 1) dfs(nx,ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int cab = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i<cab;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            int count=0;

            for(int i = 0; i< N; i++){
                for(int j = 0 ; j < M; j++){
                    if(board[i][j] == 1 && !visited[i][j]){
                       count++;
                       dfs(i,j);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
