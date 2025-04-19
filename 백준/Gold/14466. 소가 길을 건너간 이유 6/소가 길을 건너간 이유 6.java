
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0 ,-1, 1};

    static int N;
    static int K;
    static int R;

    static Set<Integer>[][] roads;

    static boolean[][] cowMap;
    static boolean[][] visited;

    static int answer;

    static int[] cowsArr;

    public static int bfs(int x, int y){
        int cowCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int nowX = temp[0];
            int nowY = temp[1];
            if(visited[nowX][nowY]) continue;
            visited[nowX][nowY] = true;
            if(cowMap[nowX][nowY]) cowCount++;
            for(int i =0; i<4; i++){
                if(roads[nowX][nowY].contains(i)) continue;
                int newX = nowX +dx[i];
                int newY = nowY +dy[i];
                if(newX < 0 || newY <0 || newX>= N || newY >= N || visited[newX][newY]) continue;
                queue.addLast(new int[] {newX, newY});
            }
        }
        return cowCount;
    }

    static boolean[] combVisit;

    public static int exeComb(int limit){
        int answer = 1;
        for(int i = 0; i< limit; i++){
            if(combVisit[i]) answer= answer* cowsArr[i];
        }
        return answer;
    }

    public static void dfs(int index, int count, int limit){
        if(count == 2){
            answer += exeComb(limit);
        }
        for(int i = index; i < limit; i++){
            if(combVisit[i]) continue;
            combVisit[i] = true;
            dfs(i, count+1, limit);
            combVisit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        roads= new HashSet[N][N];
        for(int i = 0; i< N; i++){
            for(int j =0; j< N; j++){
                roads[i][j] = new HashSet<>();
            }
        }

        for(int r = 0 ; r < R; r++){ // 길이 이어져 있는 방향 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            for(int i =0; i<4;i ++){
                if(y2-y1 == dy[i] && x2-x1 == dx[i]){
                    roads[x1][y1].add(i);
                }
                if(y1-y2 == dy[i] && x1-x2 == dx[i]){
                    roads[x2][y2].add(i);
                }
            }
        }

        cowMap = new boolean[N][N];
        visited = new boolean[N][N];

        for(int k = 0 ; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            cowMap[x][y] = true;
        }
        List<Integer> cowsList = new ArrayList<>();
        int answer = K*(K-1)/2;
        for(int i = 0 ; i< N; i++){
            for(int j = 0; j<N ;j++){
                if(visited[i][j]) continue;
                int cow = bfs(i,j);
                answer -= cow*(cow-1)/2;
            }
        }
        System.out.println(answer);
    }
}
