import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 동전 개수
        int k = sc.nextInt(); // 목표 금액

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 1000000000); // 큰 값으로 초기화
        dp[0] = 0; // 0원을 만들기 위한 동전 수는 0

        for (int i = 0; i < n; i++) {
            int w = coins[i];
            if (w <= k) dp[w] = 1; // 해당 동전 1개로 만들 수 있는 경우
            for (int j = w + 1; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - w] + 1);
            }
        }

        System.out.println(dp[k] == 1000000000 ? -1 : dp[k]);
    }
}
