import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] dp;
    static int[] hArr;
    static int[] pArr;

    static int binarySearch(int left, int right, int num){
        int res = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(hArr[mid] <= num){
                res = mid;  // 조건 만족하는 인덱스
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            else return o1[0]-o2[0];
        });

        Set<Integer> heightSet = new HashSet<>();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken()); //height;
            int price = Integer.parseInt(st.nextToken()); //price;
            pq.add(new int[] {height, price});
            heightSet.add(height);
        }

        int index = 0;
        int height = -1;

        N=heightSet.size();

        dp = new int[N];
        hArr = new int[N];
        pArr = new int[N];

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(height == temp[0]) continue;
            hArr[index] = temp[0];
            pArr[index] = temp[1];
            height = temp[0];
            index++;
        }

        dp[0] = pArr[0];

        for(int i = 1; i<N; i++){
            int idx = binarySearch(0, i, hArr[i] - S);
            if(idx == -1){
                dp[i] = Math.max(dp[i-1], pArr[i]);
            }else{
                dp[i] = Math.max(dp[i-1], dp[idx] + pArr[i]);
            }
        }

        System.out.println(dp[N-1]);

    }
}
