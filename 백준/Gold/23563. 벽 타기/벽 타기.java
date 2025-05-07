
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[][] map;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static boolean isNearWall(int x, int y){
        for(int i = 0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX<0 || newX>=N || newY<0 || newY>=M) continue;
            if(map[newX][newY] == 1) return true;
        }
        return false;
    }

    static int bfs(int[] start, int[] end){
        int endX = end[0];
        int endY = end[1];
        int answer = -1;
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{start[0], start[1], 0});
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            if(visited[x][y]) continue;
            visited[x][y] = true;
            if(x == endX && y == endY){
                answer = time;
                break;
            }

            for(int i = 0; i<4; i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue; //

                if(!visited[newX][newY] && map[newX][newY] != 1){
                    if(isNearWall(x,y) && isNearWall(newX, newY)){
                        queue.addFirst(new int[] {newX, newY, time});
                    }else{
                        queue.addLast(new int[] {newX, newY, time+1});
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
        map = new int[N][M];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for(int i = 0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                 char c = line.charAt(j);
                 if(c=='#') {
                     map[i][j] = 1;
                 }else{
                     map[i][j] = 0;
                 }
                 if(c=='S'){
                     startX = i;
                     startY = j;
                 }
                 if(c=='E'){
                     endX = i;
                     endY = j;
                 }
            }
        }

        System.out.println(bfs(new int[] {startX, startY}, new int[] {endX, endY}));

    }
}
