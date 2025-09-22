import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<Set<Integer>> setList;

    static Set<Integer> truthSet = new HashSet<>();
    static boolean[] visited;

    static int answer = 0;

    public static void bfs(int index) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean isPossible = true;
        queue.addLast(index);
        int count = 0;
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            Set<Integer> nowSet = setList.get(now);
            for(Integer x : nowSet){
                if(truthSet.contains(x)) isPossible = false;
            }
            count++;
            for(int i =0; i<M;i++) {
                if(!visited[i]){
                    for(Integer y : nowSet){
                        if(setList.get(i).contains(y)) {
                            queue.addLast(i);
                            visited[i] = true;
                            break;
                        }
                    }

                }
            }
        }
        if(isPossible) answer+=count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n ; i++) {
            truthSet.add(Integer.parseInt(st.nextToken()));
        }
        setList = new ArrayList<>();
        visited = new boolean[M];

        for(int i = 0 ; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            setList.add(set);
        }

        for(int i = 0; i< M; i++) {
            if(visited[i]) continue;
            bfs(i);
        }

        System.out.println(answer);
    }
}
