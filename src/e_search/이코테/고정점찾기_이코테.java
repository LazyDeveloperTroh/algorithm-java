package e_search.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 배열의 중심값을 찾아서 인덱스와 일치하는지 확인
 * 2. 중심값보다 인덱스가 작다면 ? 좌측 이분탐색
 * 3. 중심값보다 인덱스가 크다면 ? 우측 이분탐색
 */
public class 고정점찾기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
        int start = 0;
        int end = numbers.size() - 1;
        int result = binarySearch(numbers, (start + end) / 2, start, end);
        System.out.println("result = " + result);
    }

    private static int binarySearch(List<Integer> numbers, int target, int start, int end) {
        System.out.println(String.format("target: %d, start: %d, end: %d", target, start, end));
        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(mid < numbers.get(target)) return binarySearch(numbers, (start + mid-1) / 2, start, mid - 1);
        else if(mid == numbers.get(target)) return mid;
        else return binarySearch(numbers, (mid+1 + end) / 2, mid+1, end);
    }


}
