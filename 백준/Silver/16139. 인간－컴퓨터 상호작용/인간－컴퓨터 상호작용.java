import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[][] alphabet = new int[str.length()+1][26];
        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j<26;j++){
                if(j == str.charAt(i-1)-'a'){
                    alphabet[i][j] = alphabet[i-1][j] +1;
                }
                else {
                    alphabet[i][j] = alphabet[i-1][j];
                }
            }

        }
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int firstIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            System.out.println(alphabet[lastIndex+1][c-'a'] - alphabet[firstIndex][c-'a']);
        }

    }
}
