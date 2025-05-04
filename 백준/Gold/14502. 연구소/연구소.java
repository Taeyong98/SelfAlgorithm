import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;

    static int[][] makeNewMap(){
        int[][] newMap= new int[N][M];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M ;j++){
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static int bfs(int[][] newMap){
        int zeroCount = 0;
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            for(int j =0; j<M; j++){
                if(newMap[i][j]!=2 || visited[i][j]) continue;
                queue.add(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    if(newMap[x][y] == 0) zeroCount++;
                    for(int d = 0; d<4; d++){
                        int newX = x+dx[d];
                        int newY = y+dy[d];
                        if(newX < 0 || newX >= N || newY <0 || newY >=M) continue;
                        if(visited[newX][newY] || newMap[newX][newY]==1) continue;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return zeroCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int zeroCount = 0;

        for(int i = 0; i <N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) zeroCount++;
                map[i][j] = num;
            }
        }
        zeroCount -= 3; //벽까지 고려한 값.

        int answer = 0;

        for(int i = 0; i<N*M-2; i++){
            for(int j = i+1; j<N*M-1; j++){
                for(int k = j+1; k<N*M; k++){
                    if(map[i/M][i%M] != 0 || map[j/M][j%M] !=0 || map[k/M][k%M] !=0) continue;
                    int[][] newMap = makeNewMap();
                    newMap[i/M][i%M] = 1;
                    newMap[j/M][j%M] = 1;
                    newMap[k/M][k%M] = 1;
                    answer = Math.max(zeroCount - bfs(newMap), answer);
                }
            }
        }

        System.out.println(answer);

    }
}
