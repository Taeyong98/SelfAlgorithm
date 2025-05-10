import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            int num = arr[i];
            while(!stack.isEmpty() && stack.peekLast()[0] < num){
                int[] temp = stack.pollLast();
                answer[temp[1]] = num;
            }
            stack.offerLast(new int[] {num ,i});
        }
        while(!stack.isEmpty()){
            int[] temp = stack.pollLast();
            answer[temp[1]] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< N; i++){
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();


    }
}
