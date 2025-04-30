import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;

    static int count1; // -1 일때
    static int count2; // 0 일때
    static int count3; // 1 일때


    public static void recursive(int x, int y, int size){
        if(size == 1){
            if(map[x][y] == -1) count1++;
            else if(map[x][y] == 0) count2++;
            else count3++;
            return;
        }

        boolean isPage = true;
        outer:for(int i = x; i<x+size ; i++){
            for(int j = y; j<y+size; j++){
                if(map[i][j] != map[x][y]){
                    isPage = false;
                    break outer;
                }
            }
        }
        if(isPage){
            if(map[x][y] == -1) count1++;
            else if(map[x][y] == 0) count2++;
            else count3++;
            return;
        }

        int newSize = size/3;
        recursive(x,y, newSize);
        recursive(x,y+newSize, newSize);
        recursive(x, y+newSize*2, newSize);
        recursive(x+newSize,y, newSize);
        recursive(x+newSize,y+newSize, newSize);
        recursive(x+newSize, y+newSize*2, newSize);
        recursive(x+newSize*2,y, newSize);
        recursive(x+newSize*2,y+newSize, newSize);
        recursive(x+newSize*2, y+newSize*2, newSize);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0,0,N);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

    }
}
