import java.util.*;


class Solution {
    int answer;

    public void dfs(int cnt, int tot, int[]picks, String[] minerals){
        boolean allUsed=true;
        for(int pick: picks){
            if(pick!=0){
                allUsed = false;
                break;
            }
        }
        if(cnt == minerals.length || allUsed){ // 미네랄을 다 캤거나, picks를 모두 사용했다면 return;
            answer = Math.min(answer,tot);
            return;
        }
        for(int i =0 ; i<picks.length; i++){
            if(picks[i]==0) continue;
            int nxt=(cnt+5>minerals.length)? minerals.length:cnt+5;
            int count = 0;
            for(int j = cnt; j<nxt; j++){
                switch(i){
                    case 0: 
                        count++;
                        break;
                    case 1: 
                        if(minerals[j].equals("diamond")) count +=5;
                        else count++;
                        break;
                    case 2:
                        if(minerals[j].equals("diamond")) count +=25;
                        else if(minerals[j].equals("iron")) count +=5;
                        else count ++;
                        break;
                }
            }
            picks[i]--;
            dfs(nxt, tot+count, picks, minerals);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        dfs(0,0,picks, minerals);
        return answer;
    }
}