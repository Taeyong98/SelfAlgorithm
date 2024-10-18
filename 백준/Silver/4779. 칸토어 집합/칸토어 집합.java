import java.io.*;

public class Main {

    public static String recursive(int n){
        if(n==0){
            return "-";
        }
        String str = recursive(n-1);
        StringBuilder empty = new StringBuilder();
        int length = str.length();
        empty.append(" ".repeat(length));
        return str + empty + str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine())!=null){
            int n = Integer.parseInt(str);
            bw.write(recursive(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
