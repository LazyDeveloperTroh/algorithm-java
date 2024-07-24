package d_sort;

/**
 * 기준 데이터를 설정(피벗)하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 변경하여 정렬하는 알고리즘
 * 시간복잡도 O(NlogN)
 */
public class 퀵정렬예제_이코테 {
    public static void main(String[] args) {
        int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i]+" ");
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && array[left] <= array[pivot])
                left += 1;
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && array[right] >= array[pivot])
                right -= 1;

            // 교차하면 작은 값과 피벗 교환
            if(left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            } // 교차하지 않았다면 left, right 교환
            else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        quickSort(array, start, right-1);
        quickSort(array, right + 1, end);
    }
}
