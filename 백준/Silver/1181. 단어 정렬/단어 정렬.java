import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i<N; i++){
            set.add(br.readLine());
        }
        br.close();
        List<String> list = new ArrayList<>(set);
        list.sort((String s1, String s2)->{
            if(s1.length()!=s2.length()){
                return s1.length()-s2.length();
            }else{
                for(int i = 0; i<s1.length(); i++){
                    if (s1.charAt(i)!=s2.charAt(i)) return s1.charAt(i)-s2.charAt(i);
                }
                return 0;
            }
        });
        list.forEach(System.out::println);

    }
}
