package e_search.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 시간복잡도 O(logN)
 */
public class 이진탐색예제_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted().toList();

        int result = binarySearch(numbers, target, 0, n - 1);
        System.out.println("result = " + (result+1));
    }

    private static int binarySearch(List<Integer> numbers, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(numbers.get(mid) > target) return binarySearch(numbers, target, start, mid - 1);
        else if(numbers.get(mid) == target) return mid;
        else return binarySearch(numbers, target, mid + 1, end);
    }
}
