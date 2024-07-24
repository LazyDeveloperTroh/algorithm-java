package e_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 부품찾기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> items = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().toList();
        int m = Integer.parseInt(br.readLine());
        List<Integer> targets = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().toList();

        for (int i = 0; i < m; i++) {
            int target = targets.get(i);
            int result = binarySearch(items, target, 0, n - 1);
            if(result == -1) {
                System.out.printf("no ");
            } else {
                System.out.printf("yes ");
            }
        }
    }

    private static int binarySearch(List<Integer> items, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(items.get(mid) > target) return binarySearch(items, target, start, mid - 1);
        else if(items.get(mid) == target) return mid;
        else return binarySearch(items, target, mid + 1, end);
    }
}
