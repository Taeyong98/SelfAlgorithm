import java.util.*;
class Solution {
    
    static int bfs(HashMap<Integer, ArrayList<Integer>> hs, int n){
        int count = 0;
        int maxDepth = 0;
        HashSet<Integer> visited = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {1, 0}); //current index, 
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int currentIndex = temp[0];
            int depth = temp[1];
            if(visited.contains(currentIndex)) continue;
            visited.add(currentIndex);
            if(depth > maxDepth){
                maxDepth = depth;
                count = 1;
            }else if(depth == maxDepth){
                count ++;
            }
            for(Integer nextIndex : hs.get(currentIndex)){
                if(!visited.contains(nextIndex)) queue.addLast(new int[] {nextIndex, depth+1});
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] edge) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        for(int[] temp : edge){
            int a = temp[0];
            int b = temp[1];
            ArrayList<Integer> aList = hs.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            ArrayList<Integer> bList = hs.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            hs.put(a, aList);
            hs.put(b, bList);
        }
        return bfs(hs, n);
    }
}