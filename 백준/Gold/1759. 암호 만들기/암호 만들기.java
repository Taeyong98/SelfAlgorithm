import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static List<Character> arr;

    static boolean isMouem(Character c){
        if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
    static void backtrack(String str, int index, int depth, int moeum, int jauem){
        if(depth == L){
            if(moeum >=1 && jauem >=2) System.out.println(str);
            return;
        }
        int temp_moeum = moeum;
        int temp_jaeum = jauem;
        for(int i = index+1; i<C; i++){
            if(isMouem(arr.get(i))) moeum++;
            else jauem++;
            str += arr.get(i);
            backtrack(str,i,depth+1,moeum,jauem);
            str = str.substring(0,str.length()-1);
            moeum = temp_moeum;
            jauem = temp_jaeum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        arr = new ArrayList<>();
        for(int i = 0; i<C;i++){
            arr.add(st.nextToken().charAt(0));
        }
        arr.sort((Character c1, Character c2)->{
            return c1-c2;
        });

        backtrack("", -1, 0,0,0);
    }
}
