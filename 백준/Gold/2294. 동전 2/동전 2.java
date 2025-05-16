import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 동전 종류 수
        int k = sc.nextInt(); // 목표 금액

        Set<Integer> coinSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coinSet.add(sc.nextInt()); // 중복 제거
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i <= k; i++) {
            if (dp[i] == INF) continue;

            for (int coin : coinSet) {
                if (i + coin <= k) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[k] == INF ? -1 : dp[k]);
    }
}
