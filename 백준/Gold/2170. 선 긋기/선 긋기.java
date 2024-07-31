import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new int[]{s,e});
        }
        list.sort((o1, o2) -> o1[0]-o2[0]);
        int start=0;
        int end = 0;
        int answer = 0;
        for(int i = 0; i<list.size();i++){
            if(i == 0){
                start = list.get(i)[0];
                end = list.get(i)[1];
                if(i==list.size()-1){
                    answer += end-start;
                    break;
                }
            }
            if(i==list.size()-1){
                if(list.get(i)[0]<=end){
                    end = Math.max(end,list.get(i)[1]);
                    answer += end-start;
                }else{
                    answer += end-start;
                    answer +=list.get(i)[1]-list.get(i)[0];
                }
                break;
            }
            if(list.get(i)[0] <= end){
                end = Math.max(end, list.get(i)[1]);
            }
            else{
                answer += end-start;
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        System.out.println(answer);
        br.close();
    }
}
