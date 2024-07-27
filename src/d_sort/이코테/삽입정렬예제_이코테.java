package d_sort.이코테;

/**
 * 데이터를 하났기 확인하며 각 데이터를 적절한 위치에 삽입하는 알고리즘(특정 데이터가 적절한 위치에 들어가기 이전에 그 앞까지의 데이터는 이미 정렬되어 있다고 가정)
 * 시간 복잡도 O(N^2), 데이터가 거의 정렬되어 있을 때 효율적임 O(N)
 */
public class 삽입정렬예제_이코테 {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;;
                } else{
                    break;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
