import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int a0 = scores[0][0]; 
        int b0 = scores[0][1]; 
        int s0 = a0 + b0;      

        for (int i = 1; i < scores.length; i++) {
            if (scores[i][0] > a0 && scores[i][1] > b0) return -1;
        }

        
        Arrays.sort(scores, (x, y) -> {
            if (x[0] != y[0]) return y[0] - x[0]; 
            return x[1] - y[1];                   
        });

        int maxSecond = -1;
        int rank = 1;

        for (int[] sc : scores) {
            int f = sc[0], s = sc[1];
            if (s < maxSecond) {
            
                continue;
            }

            if (f + s > s0) rank++;
            maxSecond = Math.max(maxSecond, s);
        }

        return rank;
    }
}
