import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

//    public static int bfs(int startX, int startY){
//        int answer = 0;
//        boolean[][][][] visited = new boolean[N][N][8][7]; //level, ate fish
//        boolean[][] eaten = new boolean[N][N]; //물고기를 먹었는지
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.offerLast(new int[] {startX,startY,2,0,0});
//        int curLevel = 2;
//        int curFishCount = 0;
//        while(!queue.isEmpty()){
//            int[] cur = queue.pollFirst();
//            int x = cur[0];
//            int y = cur[1];
//            int level = cur[2];
//            int fishCount = cur[3];
//            int depth = cur[4];
//            if(level != curLevel || fishCount != curFishCount) continue;
//            if(visited[x][y][level][fishCount]) continue;
//            visited[x][y][level][fishCount] = true;
//            if(map[x][y]!=0 && map[x][y] < curLevel && !eaten[x][y]){
//                System.out.println(x + " " + y);
//                if(curLevel < 7){
//                    curFishCount++;
//                    if(curFishCount == curLevel){
//                        curLevel++;
//                        curFishCount = 0;
//                    }
//                }
//                eaten[x][y] = true;
//                answer = depth;
//            }
//            for(int d = 0; d<4; d++){
//                int newX = x +dx[d];
//                int newY = y +dy[d];
//                if(newX < 0 || newX >= N || newY <0 || newY >=N) continue;
//                if(visited[newX][newY][curLevel][curFishCount]) continue;
//                if(map[newX][newY] != 0 && map[newX][newY] > curLevel) continue;
//                queue.offerLast(new int[] {newX, newY, curLevel, curFishCount, depth+1});
//            }
//        }
//
//        return answer;
//    }

    static int bfs(int startX, int startY) {
        int answer = 0;
        int level = 2;
        int fishCount = 0;
        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}}; // 위 → 왼 → 오 → 아래 (우선순위 반영됨)

        while (true) {
            boolean[][] visited = new boolean[N][N];
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {startX, startY, 0});
            visited[startX][startY] = true;

            List<int[]> fishList = new ArrayList<>();
            int minDist = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int dist = cur[2];

                if (dist > minDist) break; // 이미 가까운 물고기 찾았으면 stop

                if (map[x][y] != 0 && map[x][y] < level) {
                    fishList.add(new int[] {x, y, dist});
                    minDist = dist;
                    continue; // 다른 후보도 찾기 위해 계속
                }

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] > level) continue; // 못 지나감
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dist + 1});
                }
            }

            if (fishList.isEmpty()) break; // 더 이상 먹을 게 없음

            // 가장 위, 가장 왼쪽 우선 정렬
            fishList.sort((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // y 오름차순
                return Integer.compare(a[0], b[0]); // x 오름차순
            });

            int[] selected = fishList.get(0);
            startX = selected[0];
            startY = selected[1];
            map[startX][startY] = 0; // 물고기 먹음
            answer += selected[2];
            fishCount++;

            if (fishCount == level) {
                level++;
                fishCount = 0;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int startX = 0;
        int startY = 0;

        map = new int[N][N];

        for(int i =0; i<N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0 ; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(bfs(startX,startY));
    }
}
