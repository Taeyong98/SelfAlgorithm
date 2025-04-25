import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int M;

    static int[] nArr;

    public static boolean binarySearch(int left, int right, int target){
        while(left <= right){
            int mid = (left + right)/2;
            if(nArr[mid] < target){
                left = mid+1;
            }else if(nArr[mid] > target){
                right = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            nArr = new int[N];
            for(int i = 0; i<N;i++){
                 nArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nArr);
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i<M; i++){
                int num = Integer.parseInt(st.nextToken());
                if(binarySearch(0, N-1, num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
