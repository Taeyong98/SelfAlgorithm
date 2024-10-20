import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int length = input.length();
        int[][] psum = new int[26][length + 1];

        fillCounts(psum, input);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            String query = br.readLine();
            printCount(bw, psum, query);
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void fillCounts(int[][] psum, String input) {
        int[] cnt = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int ch = input.charAt(i) - 'a';
            cnt[ch]++;
            for (int j = 0; j < 26; j++) {
                psum[j][i + 1] = cnt[j];
            }
        }
    }

    public static void printCount(BufferedWriter bw, int[][] psum, String query) throws IOException {
        StringTokenizer st = new StringTokenizer(query);
        int ch = st.nextToken().charAt(0) - 'a';
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        bw.write(psum[ch][to + 1] - psum[ch][from] + "\n");
    }
}
