import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static boolean check(String[] map){
        for(int i = 0; i<5; i++){
            for(int j =0; j<5; j++){
                if (map[i].charAt(j) == 'P'){
                    boolean[][] visited = new boolean[5][5];
                    Deque<int[]> stack = new ArrayDeque<>();
                    visited[i][j] = true;
                    for(int d = 0; d<4; d++){
                        int newX = i+dx[d];
                        int newY = j+dy[d];
                        if(newX>=5 || newY>=5 ||newX<0 || newY<0) continue;
                        if(map[newX].charAt(newY) == 'X') continue;
                        System.out.println(newX+ ", " +newY);
                        stack.addLast(new int[] {newX, newY, 1});
                    }
                    while(!stack.isEmpty()){
                        int[] temp = stack.pollLast();
                        int x = temp[0];
                        int y = temp[1];
                        int depth = temp[2];
                        if(visited[x][y]) continue;
                        visited[x][y] =true;
                        if(map[x].charAt(y)=='P'){
                            return false;  
                        } 
                        if(depth == 2) continue;
                        for(int d = 0; d<4; d++){
                            int newX = x+dx[d];
                            int newY = y+dy[d];
                            if(newX>=5 || newY>=5 ||newX<0 || newY<0) continue;
                            if(map[newX].charAt(newY) == 'X'||visited[newX][newY]) continue;
                            stack.addLast(new int[] {newX, newY, depth+1});
                        }
                    } 
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int n=0; n<places.length; n++){
            if(check(places[n])) answer[n] = 1;
        }
        
        return answer;
    }
}