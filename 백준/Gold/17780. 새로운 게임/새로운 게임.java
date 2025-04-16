
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static int changeDir(int dir){
        if(dir == 0){
            return 1;
        }
        else if(dir == 1){
            return 0;
        }
        else if(dir ==2){
            return 3;
        }
        else return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] horseMap = new int[K][3];
        Deque<Integer>[][] dequeMap = new ArrayDeque[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dequeMap[i][j] = new ArrayDeque<>();
            }
        }

        for(int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k = 0; k<K ; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            horseMap[k][0] = x-1;
            horseMap[k][1] = y-1;
            horseMap[k][2] = dir-1;
            dequeMap[x-1][y-1].offer(k);
        }

        int turnCount = 0;
        boolean condition = true;
        while(turnCount <= 1000 && condition){
            for(int k = 0; k<K ; k++){
                int x = horseMap[k][0];
                int y = horseMap[k][1];
                int dir = horseMap[k][2];
                if(dequeMap[x][y].isEmpty() || dequeMap[x][y].peekFirst() != k) continue;

                int newX = x+dx[dir];
                int newY = y+dy[dir];
                if(newX >= N || newY >= N || newX <0 || newY <0 || map[newX][newY] == 2){ // 다음이 파란색일 때
                    horseMap[k][2] = changeDir(dir);
                    newX = x+dx[horseMap[k][2]];
                    newY = y+dy[horseMap[k][2]];
                    if(newX >= N || newY >= N || newX <0 || newY <0 || map[newX][newY] == 2){ // 또 파랑일때
                        horseMap[k][2] = dir;
                        continue;
                    }
                    else if(map[newX][newY] == 1){ // 빨간색일때
                        Deque<Integer> temp = new ArrayDeque<>();
                        while(!dequeMap[x][y].isEmpty()){
                            temp.addLast(dequeMap[x][y].pollFirst());
                        }
                        while(!temp.isEmpty()){
                            dequeMap[x][y].offerLast(temp.pollLast());
                        }
                    }

                }
                else if(map[newX][newY] == 1){ // 빨간색일때
                    Deque<Integer> temp = new ArrayDeque<>();
                    while(!dequeMap[x][y].isEmpty()){
                        temp.addLast(dequeMap[x][y].pollFirst());
                    }
                    while(!temp.isEmpty()){
                        dequeMap[x][y].offerLast(temp.pollLast());
                    }
                }
                while(!dequeMap[x][y].isEmpty()){
                    int horse = dequeMap[x][y].pollFirst();
                    horseMap[horse][0] = newX;
                    horseMap[horse][1] = newY;
                    dequeMap[newX][newY].addLast(horse);
                }
                if(dequeMap[newX][newY].size() >= 4){
                    condition=false;
                    break;
                }

            }
            turnCount++;
        }
        if(!condition) System.out.println(turnCount);
        else System.out.println(-1);


    }
}
