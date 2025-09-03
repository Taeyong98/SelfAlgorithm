import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, List<long[]>> map;
    static int N;

    static boolean[] visit;

    static long[] amount;

    static long global = 1;

    static long gcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while(y!=0) {
            long t = x%y;
            x=y;
            y=t;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        // 초기화
        StringTokenizer st;
        map = new HashMap<>();
        visit = new boolean[N];
        amount = new long[N];

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long from = Long.parseLong(st.nextToken());
            long to = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long gg = gcd(x,y);
            x = x/gg;
            y = y/gg;

            global *= x;
            global *= y;

            List<long[]> fromList = map.getOrDefault(from, new ArrayList<>());
            map.put(from, fromList);
            fromList.add(new long[]{to,x,y});
            List<long[]> toList = map.getOrDefault(to, new ArrayList<>());
            map.put(to, toList);
            toList.add(new long[]{from,y,x});

        }

        amount[0] = global;
        dfs(0);

        long s = 0;
        for(int i = 0; i< N; i++){
            s = gcd(amount[i], s);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< N; i++){
            amount[i] /= s;
            sb.append(amount[i]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();;
    }


    static void dfs(long currentNode) {
        if(visit[(int) currentNode]){
            return;
        }
        visit[(int) currentNode] = true;
        long curAmount = amount[(int) currentNode];
        List<long[]> list = map.get(currentNode);
        for(long[] tmp : list){
            long next = tmp[0];
            long x = tmp[1];
            long y = tmp[2];
            amount[(int) next] = curAmount * y / x;
            dfs(next);
        }
    }
}
