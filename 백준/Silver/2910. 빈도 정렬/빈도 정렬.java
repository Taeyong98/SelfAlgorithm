import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Hashtable<Integer, int[]> dict = new Hashtable<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            int [] temp = dict.getOrDefault(num, new int[]{0,i}); // [0] = 나온 횟수, [1] = 그 숫자가 처음 나온 인덱스
            temp[0]+=1;
            dict.put(num, temp);
        }
        List<int[]> list = new ArrayList<>();
        for(Integer key : dict.keySet()){
            int[] temp = dict.get(key);
            list.add(new int[]{temp[0], temp[1], key}); // [0] = 나온 횟수, [1] = 그 숫자가 처음 나온 인덱스, [2] = 해당 숫자 
        }
        list.sort((int[] a1, int[] a2)->{
            if(a1[0] != a2[0]){
                return a2[0]- a1[0];
            }else{
                return a1[1] - a2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        list.forEach((int[] a)->{
            for(int i = 0; i<a[0]; i++){
                sb.append(a[2]).append(" ");
            }
        });
        System.out.println(sb.toString().trim());
        br.close();
    }
}
