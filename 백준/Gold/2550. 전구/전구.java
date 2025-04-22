import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr1;
    static int[] arr2;
    static int[] dp;
    static int[] tracking;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N+1];
        arr2 = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i<=N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =1 ; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j = 1; j<=N; j++){
                if(num == arr1[j]) arr2[j] = i;
            }
        }
        dp = new int[N+1];
        tracking = new int[N+1];

        for(int i=1 ; i<=N; i++){
            int index = 0;
            int count = 0;
            for(int j=0 ; j<i; j++){
                if(arr2[i] > arr2[j] && dp[j]>=count){
                    count = dp[j];
                    index = j;
                }
            }
            dp[i] = count+1;
            tracking[i] = index;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i = 0; i<= N; i++){
            if(dp[i] >= max){
                index = i;
                max = dp[i];
            }
        }
        sb.append(dp[index]).append("\n");
        List<Integer> list = new ArrayList<>();
        while(index != 0){
            list.add(arr1[index]);
            index = tracking[index];
        }

        list.sort((o1,o2)->o1-o2);
        for(Integer i : list){
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
