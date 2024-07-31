import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static int convert(String month, String day){
        return Integer.parseInt(month)*100 + Integer.parseInt(day);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<N;i++){
            String[] lines = br.readLine().split(" ");
            int start = convert(lines[0], lines[1]);
            int end = convert(lines[2], lines[3]);
            list.add(new int[]{start, end});
        }
        list.sort(Comparator.comparingInt(o -> o[0]));
        int answer = 0;
        int current_max = 0;
        int due =301;
        int over = 1130;
        for(int i = 0; i<list.size(); i++){
            current_max = Math.max(current_max, list.get(i)[1]);
            if(i<list.size()-1){
                if(list.get(i)[0]>due){
                    answer = 0;
                    break;
                }
                if(list.get(i+1)[0]>due){
                    answer += 1;
                    due = current_max;
                    if(due > over) break;
                }
            }
            if(i == list.size()-1){
                if(list.get(i)[0]>due){
                    answer = 0;
                    break;
                }
                answer+=1;
                due = current_max;
            }
        }
        if(due<=over) System.out.println(0);
        else System.out.println(answer);
    }
}
