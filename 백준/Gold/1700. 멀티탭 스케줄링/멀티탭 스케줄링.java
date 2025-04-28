import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] kArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kArr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            kArr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < K; i++){
            if(set.contains(kArr[i])) {
                continue;
            }
            if(set.size() < N){
                set.add(kArr[i]);
                continue;
            }
            int latestUse = -1;
            int popNum = -1;
            for (int num : set) {
                int nextUse = Integer.MAX_VALUE;
                for (int j = i + 1; j < K; j++) {
                    if (kArr[j] == num) {
                        nextUse = j;
                        break;
                    }
                }
                if (nextUse > latestUse) {
                    latestUse = nextUse;
                    popNum = num;
                }
            }
            set.remove(popNum);
            set.add(kArr[i]);
            count++;
        }
        System.out.println(count);
    }
}
