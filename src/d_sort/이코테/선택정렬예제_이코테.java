package d_sort.이코테;

/**
 * 가장작은 원소를 찾아서 앞에서부터 SWAP 하여 정렬
 * 시간복잡도 O(N^2)
 */
public class 선택정렬예제_이코테 {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i]+" ");
        }
    }
}
