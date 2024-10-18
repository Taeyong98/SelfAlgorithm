import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = -999; i<1000; i++){
            for(int j = -999 ; j<1000 ; j++){
                if((i*a + j*b == c) && (i*d + j*e ==f)){
                    sb.append(i).append(" ").append(j);
                }
            }
        }
        System.out.println(sb);
    }
}
