package e_search.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 분할정복 해야할듯??
 * 1. O(logN) 알고리즘 필요 -> 이분탐색
 * 2. X를 찾으면 좌우 모두 이분탐색,
 *    MID 가 X보다 작으면 오른쪽 이분탐색
 *    MID 가 X보다 크면 왼쪽 이분탐색
 */
public class 정렬된배열에서특정수의개수구하기_이코테 {
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
        binarySearch(numbers, x, 0, numbers.size()-1);

        if(result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void binarySearch(List<Integer> numbers, int target, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        if (target > numbers.get(mid)) {
            binarySearch(numbers, target, mid + 1, end);
        } else if(target == numbers.get(mid)) {
            result++;
            binarySearch(numbers, target, mid + 1, end);
            binarySearch(numbers, target, start, mid-1);
        } else {
            binarySearch(numbers, target, start, mid-1);
        }


    }
}
