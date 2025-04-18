
import java.io.*;

public class Main {
    static long[] numArr;
    static char[] exprArr;

    static long[][] maxDp;
    static long[][] minDp;

    static long answer;

    public static long calculate(long x, char expr, long y){
        if(expr == '+'){
            return x+y;
        }
        if (expr == '*'){
            return x*y;
        }
        return x-y;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        numArr = new long[N/2 +1];
        maxDp = new long[N/2 +1][N/2 +1];
        minDp = new long[N/2 +1][N/2 +1];
        exprArr = new char[N/2];
        for(int n = 0 ; n<N ;n ++){
            if(n%2 == 0){
                numArr[n/2] = line.charAt(n) - '0';
            }
            else{
                exprArr[n/2] = line.charAt(n);
            }
        }



        for(int i = 0 ; i < numArr.length; i++){
            maxDp[i][i] = numArr[i];
            minDp[i][i] = numArr[i];
        }

        answer = Long.MIN_VALUE;

        for (int length = 1; length < numArr.length; length++) {
            for (int i = 0; i + length < numArr.length; i++) {
                int j = i + length;
                long minResult = Long.MAX_VALUE;
                long maxResult = Long.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    long a = calculate(maxDp[i][k], exprArr[k], maxDp[k + 1][j]);
                    long b = calculate(maxDp[i][k], exprArr[k], minDp[k + 1][j]);
                    long c = calculate(minDp[i][k], exprArr[k], maxDp[k + 1][j]);
                    long d = calculate(minDp[i][k], exprArr[k], minDp[k + 1][j]);

                    minResult = Math.min(minResult, Math.min(Math.min(a, b), Math.min(c, d)));
                    maxResult = Math.max(maxResult, Math.max(Math.max(a, b), Math.max(c, d)));
                }
                minDp[i][j] = minResult;
                maxDp[i][j] = maxResult;
            }
        }

        System.out.println(maxDp[0][numArr.length-1]);
        br.close();
    }
}
