import java.util.*;

class Solution {
    static int answer;
    static boolean check(int[] memo, int depth, int index){
        for(int i = 0; i<depth; i++){
            if(Math.abs(i-depth) == Math.abs(memo[i]-index)||memo[i]==index) return false;
        }
        return true;
    }
    
    static void backtrack(int[] memo, int depth, int n){
        if(depth == n){
            answer ++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(check(memo, depth, i)) {
                memo[depth] = i;
                backtrack(memo, depth+1, n);
            }
        }
    }
    public int solution(int n) {
        answer = 0;
        int[] memo = new int[n];
        backtrack(memo,0,n);
        return answer;
    }
}