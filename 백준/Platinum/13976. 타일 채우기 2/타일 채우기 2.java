import java.util.Scanner;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }
        N /= 2;

        long[][] baseMatrix = {
            {4, MOD - 1}, // 4, -1 (mod 처리)
            {1, 0}
        };
        long[][] resultMatrix = matrixPower(baseMatrix, N - 1);

        // 초기값 f(1) = 3, f(0) = 1
        long f1 = 3;
        long f0 = 1;

        long answer = (resultMatrix[0][0] * f1 + resultMatrix[0][1] * f0) % MOD;
        System.out.println(answer);
    }

    static long[][] matrixMultiply(long[][] A, long[][] B) {
        int n = A.length;
        int m = B[0].length;
        int p = B.length;

        long[][] result = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    static long[][] matrixPower(long[][] matrix, long exp) {
        int size = matrix.length;
        long[][] result = new long[size][size];

        // 단위 행렬
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            exp >>= 1;
        }
        return result;
    }
}
