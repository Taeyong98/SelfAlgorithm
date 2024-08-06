import java.util.*;
class Solution {
    // 레버 : 2
    // exit : 3
    // 벽 : 1
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0 ,0 , 1, -1};

    
    
    static int bfs(boolean[][] visited, int[][] map, int start_x, int start_y, int n, int m, int target){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{start_x, start_y , 0});
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int x = temp[0];
            int y = temp[1];
            int depth = temp[2];
            if(map[x][y] == target) return depth;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            for(int i = 0; i<4; i++){
                int new_x = x+dx[i];
                int new_y = y+dy[i];
                if(new_x >= n || new_y>=m || new_x<0 || new_y<0) continue;
                if(visited[new_x][new_y]||map[new_x][new_y] == 1) continue;
                queue.addLast(new int[] {new_x, new_y, depth+1});
            }
        }
        return -1;
        
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        int start_x = 0;
        int start_y = 0;
        int lever_x = 0;
        int lever_y = 0;
        
        boolean [][] visited = new boolean[n][m];
        int[][] map = new int[n][m];
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m; j++){
                switch(maps[i].charAt(j)){
                    case 'S':
                        start_x = i;
                        start_y = j;
                        break;
                    case 'X':
                        map[i][j] = 1;
                        break;
                    case 'L':
                        map[i][j] = 2;
                        lever_x=i;
                        lever_y=j;
                        break;
                    case 'E':
                        map[i][j] = 3;
                        break;           
                }
            }
        }
        
        int lever = bfs(visited, map, start_x, start_y, n, m, 2);
        if(lever == -1) return -1;
        answer += lever;
        visited = new boolean[n][m];
        int exit =  bfs(visited, map, lever_x, lever_y, n,m,3);
        if(exit == -1) return -1;
        answer += exit;
        return answer;
    }
}