
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> teamList = new ArrayList<>();

    static int N;
    static int startScore;
    static int linkScore;

    static int[][] board;

    static void setTeamList(int depth, int index, int[] team){
        if(depth == N/2){
            int[] temp = new int[N];
            System.arraycopy(team, 0, temp, 0, N);
            teamList.add(temp);
            return;
        }
        for(int i = index; i<N; i++){
            team[i] = 1;
            setTeamList(depth+1, i+1, team);
            team[i] = 0;
        }
    }

    static void dfsStartScore(int depth, int index, int[] startArray, int[] team){
        if(depth==2){
            startScore+=board[startArray[0]][startArray[1]];
            startScore+=board[startArray[1]][startArray[0]];
            return;
        }
        for(int i = index; i<N; i++){
            if(team[i] == 1){
                startArray[depth] = i;
                dfsStartScore(depth+1, i+1,startArray,team);
            }
        }
    }
    static void dfsLinkScore(int depth, int index, int[] linkArray, int[] team){
        if(depth==2){
            linkScore+=board[linkArray[0]][linkArray[1]];
            linkScore+=board[linkArray[1]][linkArray[0]];
            return;
        }
        for(int i = index; i<N; i++){
            if(team[i] == 0){
                linkArray[depth] = i;
                dfsLinkScore(depth+1, i+1, linkArray,team);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int [N][N];
        StringTokenizer st;
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setTeamList(0,0 ,new int[N]);
        int answer = Integer.MAX_VALUE;
        for(int[] team : teamList){
            startScore = 0;
            linkScore = 0;
            dfsStartScore(0,0,new int[2], team);
            dfsLinkScore(0,0,new int[2], team);
            answer = Math.min(Math.abs(startScore- linkScore),answer);
        }
        System.out.println(answer);
        br.close();
    }
}
