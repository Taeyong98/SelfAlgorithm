import java.util.*;

class Solution {
    //wires 중에 하나를 빼고 그래프를 그리면 되지 않을까? 그중에 최소값을 계속 넣으면 될듯.
    // 브루트 포스 + dfs or bfs
    //
    public int bfs(HashMap<Integer, ArrayList<Integer>> map){
        Deque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.addLast(1);
        int count = 0;
        while(!queue.isEmpty()){
            int currentIndex = queue.pollFirst();
            if(visited.contains(currentIndex)) continue;
            visited.add(currentIndex);
            count++;
            for(Integer next : map.getOrDefault(currentIndex, new ArrayList<Integer>())){
                if(!visited.contains(next)) queue.add(next);
            }
        }
        return count;
    }
    
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        for(int i = 0; i<wires.length; i++){
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int j = 0; j < wires.length ; j++){
                if(j == i) continue; // wire를 끊는 과정
                int a = wires[j][0];
                int b = wires[j][1];
                ArrayList<Integer> aList = map.getOrDefault(a, new ArrayList<>());
                aList.add(b);
                ArrayList<Integer> bList = map.getOrDefault(b, new ArrayList<>());
                bList.add(a);
                map.put(a, aList);
                map.put(b, bList);
            }
            int count = bfs(map);
            answer = Math.min(answer,Math.abs(n-count-count));
        }
        return answer;
    }
}