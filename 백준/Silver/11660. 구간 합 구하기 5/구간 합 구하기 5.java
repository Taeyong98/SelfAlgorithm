import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] prefixSumArray = new int[n+1][n+1];
        for(int i = 1 ; i <= n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int num = Integer.parseInt(st.nextToken());
                prefixSumArray[i][j] = prefixSumArray[i-1][j]+ prefixSumArray[i][j-1] - prefixSumArray[i-1][j-1] + num;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(prefixSumArray[x2][y2]-prefixSumArray[x1-1][y2]-prefixSumArray[x2][y1-1]+prefixSumArray[x1-1][y1-1]).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
