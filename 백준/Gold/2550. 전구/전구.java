import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr1, arr2, dp, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new int[N];
        arr2 = new int[N];
        dp = new int[N];            // LIS 값을 저장할 배열 (인덱스)
        prev = new int[N];          // 이전 인덱스 저장

        Map<Integer, Integer> map = new HashMap<>(); // arr1[i] -> index 매핑

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            map.put(arr1[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr2[i] = map.get(val); // arr2는 arr1의 인덱스 순서를 나타냄
        }

        // LIS 수행
        int[] lis = new int[N];           // LIS 실제 값을 저장
        int[] lisIndex = new int[N];      // LIS 위치에 있는 arr2 인덱스 저장
        int length = 0;

        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            int pos = lowerBound(lis, 0, length, arr2[i]);
            lis[pos] = arr2[i];
            lisIndex[pos] = i;

            if (pos > 0) {
                prev[i] = lisIndex[pos - 1];
            }

            if (pos == length) length++;
        }

        // 역추적
        List<Integer> result = new ArrayList<>();
        int idx = lisIndex[length - 1];
        while (idx != -1) {
            result.add(arr1[arr2[idx]]);
            idx = prev[idx];
        }

        Collections.sort(result);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    // Lower Bound 이진 탐색 (arr[mid] >= target 인 최소 인덱스 반환)
    public static int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
