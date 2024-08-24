package e_search.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정렬된배열에서특정수의개수구하기2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Integer[] array = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        int first = binarySearchFirstIndex(array, 0, array.length - 1, x);
        int last = binarySearchLastIndex(array, 0, array.length - 1, x);

        if(first == last && first == -1) {
            System.out.println(-1);
        } else if (first == last && first != -1) {
            System.out.println(1);
        } else {
            System.out.println(last-first+1);
        }
    }

    private static int binarySearchFirstIndex(Integer[] array, int start, int end, int target) {
        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(array[mid] == target && (mid == 0 || array[mid-1] < target )) {
            return mid;
        } else if(array[mid] >= target) {
            return binarySearchFirstIndex(array, start, mid - 1, target);
        } else {
            return binarySearchFirstIndex(array, mid + 1, end, target);
        }
    }


    private static int binarySearchLastIndex(Integer[] array, int start, int end, int target) {
        if(start>end) return -1;

        int mid = (start + end) / 2;
        if(array[mid] == target && (mid == array.length-1 || array[mid+1] > target)) {
            return mid;
        } else if(array[mid] <= target) {
            return binarySearchLastIndex(array, mid+1, end, target);
        } else {
            return binarySearchLastIndex(array, start, mid-1, target);
        }
    }
}
