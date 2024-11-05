import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board;

    static StringBuilder sb;
    static List<int[]> blankList = new ArrayList<>();

    static boolean flag;
    static boolean checkRow(int row, int num){
        for(int i = 0 ; i<9 ;i++){
            if(board[row][i] == num) return false;
        }
        return true;
    }

    static boolean checkCol(int col, int num){
        for(int i = 0 ; i<9 ;i++){
            if(board[i][col] == num) return false;
        }
        return true;
    }

    static boolean checkBox(int row, int col, int num){
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow; i<startRow+3; i++){
            for(int j = startCol; j<startCol+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

    static void dfs(int depth){
        if(flag) return;
        if(depth==blankList.size()){
            flag = true; // 첫 도착
            for(int i = 0; i<9; i++){
                for(int j =0;j<9;j++){
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return;
        }
        int[] spot = blankList.get(depth);
        int x = spot[0];
        int y = spot[1];
        for(int i = 1; i<=9; i++){
            if(checkRow(x,i) && checkCol(y,i) && checkBox(x,y,i)){
                board[x][y] = i;
                dfs(depth+1);
                board[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        sb = new StringBuilder();
        for(int i = 0; i<9; i++){
            String line = br.readLine();
            for(int j = 0; j<9;j++){
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                if(board[i][j]==0) blankList.add(new int[]{i,j});
            }
        }
        dfs(0);
        System.out.println(sb.toString());
        br.close();

    }
}
