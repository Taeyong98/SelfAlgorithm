import java.util.*;
class Solution {
    static boolean[] visited;
    static int N;
    static int[][] board;
    static void backtrack(int n){
        visited[n] = true;
        for(int i =0; i<N;i++){
            if(i==n){
                continue;
            }
            if(board[n][i]==1 && !visited[i]){
                backtrack(i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visited = new boolean[n];
        board = computers;
        for(int i = 0; i<n;i++){
            if (visited[i]){
                continue;
            }
            backtrack(i);
            answer++;
        }
        return answer;
    }
}