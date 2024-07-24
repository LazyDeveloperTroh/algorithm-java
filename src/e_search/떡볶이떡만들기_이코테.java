package e_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 떡볶이떡만들기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> arrays = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

        int result = binarySearch(arrays, m, 0, 1000000000, 0);
        System.out.println("result = " + result);
    }

    private static int binarySearch(List<Integer> arrays, int target, int start, int end, int result) {
        if (start > end) return result;

        int mid = (start + end) / 2;
        int sum = 0;
        for(int i=0; i<arrays.size(); i++) {
            Integer h = arrays.get(i);
            if(h > mid) {
                sum += (h - mid);
            }
        }

        if(sum > target) return binarySearch(arrays, target, mid + 1, end, result);
        else {
            return binarySearch(arrays, target, start, mid - 1, mid);
        }
    }
}
