import java.io.*;
import java.util.*;

public class Main {
    public static int X;

    public static int Y;

    public static int N;

    public static int[] dx = {-1, 1, 0, 0};

    public static int[] dy = {0, 0 ,-1 ,1};

    public static int[][] map;

    public static List<int[]> bfsVisitNode;

    public static boolean isLeft = true;

    public static void fallAction(){ // 분리된 클러스터 떨어뜨리는 용도
        bfsVisitNode.sort(((o1, o2) -> o2[0]-o1[0])); // x 내림차순으로 sort
        List<int[]> rollBackVisitNode = new ArrayList<>();
        for(int[] nowNode : bfsVisitNode){
            rollBackVisitNode.add(new int[] {nowNode[0], nowNode[1]});
        }
        int dropCount = 0;
        boolean condition = true;
        int[][] copyMap = new int[X][Y];
        for(int i = 0; i< X; i++){
            for(int j = 0; j<Y ; j++){
                copyMap[i][j] = map[i][j];
            }
        }
        while(condition && !bfsVisitNode.isEmpty()){
            List<int[]> nextVisitNode = new ArrayList<>();
            for(int[] nowNode : bfsVisitNode){
                int nowX = nowNode[0];
                int nowY = nowNode[1];

                if(nowX+1 >= X || copyMap[nowX+1][nowY] == 1 ){
                    condition = false;
                    break;
                }
                copyMap[nowX][nowY] = 0;
                copyMap[nowX+1][nowY] = 1;

                nextVisitNode.add(new int[] {nowX+1, nowY});
            }
            bfsVisitNode = nextVisitNode;
            if(condition) dropCount++;
        }
        for(int[] nowNode : rollBackVisitNode){
            int nowX = nowNode[0];
            int nowY = nowNode[1];
            map[nowX][nowY] = 0;
            map[nowX+dropCount][nowY] = 1;
        }

    }

    public static int bfs(boolean[][] visited, int x, int y){
        Deque<int []> queue = new ArrayDeque<>();
        queue.offerLast(new int [] {x,y});
        int height = 0;
        while(!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            int nowX = temp[0];
            int nowY = temp[1];
            if(visited[nowX][nowY]) continue;
            visited[nowX][nowY] = true;
            bfsVisitNode.add(new int[] {nowX, nowY});
            height = Math.max(nowX, height);
            for(int i =0 ; i<4 ; i++){
                int newX = nowX+dx[i];
                int newY = nowY+dy[i];
                if(newX < 0 || newY <0 || newX >= X || newY >= Y || visited[newX][newY] || map[newX][newY] == 0) continue;
                queue.addLast(new int[] {newX, newY});
            }
        }
        if(height != X-1){
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        //높이 = X-1
        map = new int[X][Y];
        for(int i = 0; i<X ; i++){
            String line= br.readLine();
            for(int j = 0; j<Y ; j++){
                if(line.charAt(j) == '.'){
                    map[i][j] = 0; // 비어있음
                }else{
                    map[i][j] = 1; // 미네랄
                }
            }
        }
        N = Integer.parseInt(br.readLine());
        int[] stickSeq = new int [N]; // 막대기 던지는 순서 왼 오 왼 오 순서로.
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            stickSeq[i] = Integer.parseInt(st.nextToken());
        }
        for(int n = 0; n <N ; n++){
            int row = stickSeq[n];
            if(isLeft){
                for(int i = 0 ; i < Y; i++){
                    if(map[X-row][i] == 1){
                        map[X-row][i] = 0;
                        break;
                    }
                }
            }else{
                for(int i = Y-1 ; i>=0 ; i--){
                    if(map[X-row][i] == 1){
                        map[X-row][i] = 0;
                        break;
                    }
                }
            }

            boolean[][] visited = new boolean[X][Y];
            boolean isFalled = false;
            for(int x = 0; x< X; x++){
                if(isFalled) break;
                for(int y = 0; y<Y ; y++){
                    if(map[x][y] == 0 || visited[x][y]) continue;
                    bfsVisitNode = new ArrayList<>();
                    if(bfs(visited, x, y) == -1){
                        fallAction();
                        isFalled = true;
                        break;
                    }
                }
            }
            isLeft = !isLeft; // 방향전환
        }
        StringBuilder sb = new StringBuilder();
        for(int x = 0 ; x<X; x++){
            for(int y = 0; y<Y ;y++){
                if(map[x][y] == 1){
                    sb.append("x");
                }
                else{
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
