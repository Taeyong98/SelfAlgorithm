class Solution {
    
    static int answer;
    
    static void backtrack(int[] numbers, int depth, int current_value, int target){
        if(depth == numbers.length){
            if(current_value == target) answer ++;
            return;
        }
        backtrack(numbers, depth+1, current_value-numbers[depth], target);
        backtrack(numbers, depth+1, current_value+numbers[depth], target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        backtrack(numbers, 0, 0, target);
        return answer;
    }
}