import java.util.*;
class Solution {
    public static boolean checkWords(String begin, String target){
        int n =begin.length();
        int count = 0;
        for(int i = 0; i<n;i++){
            if(begin.charAt(i)!=target.charAt(i)) count++;
        }
        return count==1;
    }
    
    public static int bfs(boolean[] visited, String begin, String target, String[] words){
        int answer = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i<words.length;i++){
            if(checkWords(begin, words[i])) queue.addLast(new int[]{i,1});
        }
        
        while(!queue.isEmpty()){
            int[]temp = queue.pollFirst();
            if(words[temp[0]].equals(target)){
                answer = temp[1];
                break;
            }
            visited[temp[0]] = true;
            for(int i = 0; i<words.length;i++){
                if(checkWords(words[temp[0]],words[i])&&!visited[i]) queue.addLast(new int[]{i,temp[1]+1});
                    
            }
        }
        return answer;
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        answer = bfs(visited, begin, target, words);
        return answer;
    }
    
    
}