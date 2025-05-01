import java.io.*;

public class Main {
    static long[] len = new long[51];    // 각 레벨 햄버거의 전체 길이
    static long[] patty = new long[51];  // 각 레벨 햄버거의 패티 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        long X = Long.parseLong(parts[1]);

        // DP 초기화
        len[0] = 1; // Level 0 햄버거: P
        patty[0] = 1;

        for (int i = 1; i <= N; i++) {
            len[i] = 2 * len[i - 1] + 3;
            patty[i] = 2 * patty[i - 1] + 1;
        }

        System.out.println(countPatty(N, X));
    }

    // level: 현재 레벨의 버거
    // x: 먹은 레이어 수
    public static long countPatty(int level, long x) {
        if (level == 0) {
            return x <= 0 ? 0 : 1; // P만 1개
        }

        if (x == 1) {
            return 0; // 처음 B
        } else if (x <= 1 + len[level - 1]) {
            return countPatty(level - 1, x - 1);
        } else if (x == 1 + len[level - 1] + 1) {
            return patty[level - 1] + 1; // 가운데 P까지 먹음
        } else if (x <= 1 + len[level - 1] + 1 + len[level - 1]) {
            return patty[level - 1] + 1 + countPatty(level - 1, x - 2 - len[level - 1]);
        } else {
            return patty[level]; // 전체 다 먹음
        }
    }
}