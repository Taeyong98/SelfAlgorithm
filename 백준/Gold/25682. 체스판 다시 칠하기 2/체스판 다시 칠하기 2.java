import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] bpsA = new int [N+1][M+1]; // black prefix sum Array
        int[][] wpsA = new int [N+1][M+1]; // white prefix sum Array

        for(int i = 1; i<=N; i++){
            String line = br.readLine();
            for(int j = 1; j<=M; j++){
                bpsA[i][j] = bpsA[i-1][j] + bpsA[i][j-1] - bpsA[i-1][j-1];
                wpsA[i][j] = wpsA[i-1][j] + wpsA[i][j-1] - wpsA[i-1][j-1];
                //틀렸으면 +1
                if((i+j)%2 == 0){ // 짝수일 때
                    if(line.charAt(j-1) == 'W'){
                        bpsA[i][j] ++;
                    }
                    else{
                        wpsA[i][j] ++;
                    }
                }
                else{
                    if(line.charAt(j-1) == 'B'){
                        bpsA[i][j] ++;
                    }else{
                        wpsA[i][j] ++;
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<= N-K+1; i++){
            for(int j = 1; j<= M-K+1; j++){
                int temp = bpsA[i+K-1][j+K-1] - bpsA[i-1][j+K-1] - bpsA[i+K-1][j-1] + bpsA[i-1][j-1];
                answer = Math.min(answer, temp);
                temp = wpsA[i+K-1][j+K-1] - wpsA[i-1][j+K-1] - wpsA[i+K-1][j-1] + wpsA[i-1][j-1];
                answer = Math.min(answer, temp);
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
