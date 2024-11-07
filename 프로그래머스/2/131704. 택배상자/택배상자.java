import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 1; i<=order.length; i++){
            stack.addFirst(i);
            while(!stack.isEmpty()&&stack.peekFirst()==order[answer]){
                answer++;
                stack.pollFirst();
            }
        }
        return answer;
    }
}