import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    //최단거리 찾는 것, BFS로 풀어야함. dfs로 풀시 길은 찾더라도 최단거리를 보장할 수 없음.
    static int answer;
    static void bfs(boolean[][] visited, int[][] maps, int n, int m){
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {0,0,1});
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int x = temp[0];
            int y = temp[1];
            int depth = temp[2];
            if(x == n-1 && y ==m-1){
                answer = depth;
            }
            if(visited[x][y]) continue;
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >= n || ny>=m || nx<0 || ny<0) continue;
                if(maps[nx][ny] == 0 || visited[nx][ny]) continue;
                queue.addLast(new int[] {nx,ny,depth+1});
            }
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        answer = -1;
        bfs(visited, maps, n, m);
        return answer;
    }
}