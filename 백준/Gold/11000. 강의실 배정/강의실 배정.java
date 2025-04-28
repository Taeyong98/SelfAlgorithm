import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < N ;i ++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[] {start, end});
        }
        list.sort(((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));

        int count = 0;
        for(int[] temp : list){
            while(!pq.isEmpty() && pq.peek()[1] <= temp[0]){
                pq.poll();
            }
            pq.add(temp);
            count = Math.max(pq.size(), count);
        }

        System.out.println(count);
    }
}
