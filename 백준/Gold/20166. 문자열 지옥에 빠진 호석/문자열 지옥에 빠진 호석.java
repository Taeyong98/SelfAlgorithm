import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;

    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1,-1, 1, -1};

    static char[][] map;

    static HashMap<String, Integer> strMap;
    static Set<String> substrSet;



    static void dfs(int x, int y, StringBuilder sb){
        sb.append(map[x][y]);
        if(!substrSet.contains(sb.toString()) || sb.length() >= 6){
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if(strMap.containsKey(sb.toString())){
            strMap.put(sb.toString(), strMap.get(sb.toString())+1);
        }
        for(int d = 0; d<8; d++){
            int newX = x+dx[d];
            int newY = y+dy[d];
            if(newX < 0){
                newX = newX + N;
            }
            if(newY < 0){
                newY = newY + M;
            }
            newX = newX%N;
            newY = newY%M;
            dfs(newX, newY,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i = 0; i< N ;i++){
            String line = br.readLine();
            for(int j = 0 ; j<M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        List<String> seq = new ArrayList<>();
        strMap = new HashMap<>();
        substrSet = new HashSet<>();
        for(int k=0 ; k<K; k++){
            String line = br.readLine();
            strMap.put(line, 0);
            seq.add(line);
            StringBuilder sb= new StringBuilder();
            for(int i = 0; i<line.length(); i++){
                sb.append(line.charAt(i));
                substrSet.add(sb.toString());
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                dfs(i,j, new StringBuilder());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String key : seq){
            sb.append(strMap.get(key)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }


}
