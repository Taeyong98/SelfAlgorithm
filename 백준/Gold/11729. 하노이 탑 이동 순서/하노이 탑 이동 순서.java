import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void hanoi(int k,int from, int mid, int to){
        if(k == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(k-1,from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(k-1, mid, from ,to);
    }
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        sb.append(((int)Math.pow(2,i)-1)).append("\n");
        hanoi(i, 1, 2, 3);
        System.out.println(sb.toString());
    }
}
