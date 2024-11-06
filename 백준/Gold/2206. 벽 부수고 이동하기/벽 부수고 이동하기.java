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
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(){
        int answer = -1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0,0,0,1});
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int x = temp[0];
            int y = temp[1];
            int wall = temp[2];
            int depth = temp[3];
            if(x==N-1 && y ==M-1) return depth;
            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][wall]){
                    if(board[nx][ny] == 1 && wall == 0 ){
                        visited[nx][ny][1] = true;
                        queue.addLast(new int[]{nx, ny, 1, depth+1});
                    }else if(board[nx][ny] == 0){
                        visited[nx][ny][wall] = true;
                        queue.addLast(new int[]{nx,ny,wall,depth+1});
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2]; //0 벽 부수기 쓴거 ,안 쓴거
        for(int i = 0; i<N; i++){
            String line = br.readLine();
            for(int j =0 ; j<M; j++){
                board[i][j] = (line.charAt(j)=='1')?1:0;
            }
        }
        System.out.println(bfs());
    }
}
