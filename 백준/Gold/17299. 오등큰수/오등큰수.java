import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static HashMap<Integer,Integer> hashMap;
    static int[] numArr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        numArr = new int[N];
        answer = new int[N];

        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num,hashMap.getOrDefault(num, 0)+1);
            numArr[i] = num;
        }

        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            int num = numArr[i];
            int freq = hashMap.get(num);
            while(!stack.isEmpty() && stack.peekLast()[0] < freq){
                int[] temp = stack.pollLast();
                answer[temp[1]] = num;
            }
            stack.offerLast(new int[] {freq, i});
        }

        for(int[] temp : stack){
            answer[temp[1]] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<N; i++){
            sb.append(answer[i]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();


    }
}
