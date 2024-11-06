import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board;
    static boolean[][] visited;

    static List<Integer> countList;
    static int N;

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int dfs(int x, int y){
        int count = 1;
        visited[x][y] = true;
        for(int d = 0 ; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx>=0 && nx<N && ny>=0 && ny < N && !visited[nx][ny] && board[nx][ny] == 1){
                count += dfs(nx,ny);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0; j<N; j++){
                board[i][j] = (line.charAt(j) == '0') ? 0 : 1;
            }
        }
        int count = 0;
        countList = new ArrayList<>();
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                if(!visited[i][j] && board[i][j] == 1){
                    count++;
                    countList.add(dfs(i,j));
                }
            }
        }
        countList.sort((Integer e1, Integer e2) ->{
            return e1-e2;
        });
        System.out.println(count);
        for(Integer i : countList) System.out.println(i);
    }
}
