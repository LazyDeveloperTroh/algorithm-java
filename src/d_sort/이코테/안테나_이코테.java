package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1. 집 위치 정렬
 * 2. 안테나가 가장 좌측에 있을 때 거리계산 (sum1)
 * 3. 안테나를 다음 집으로 이동했을 때 거리계산 (sum2)
 *     - 1번 집과 2번집의 거리를 k라고 할때 sum2 = sum1 + (안테나 포함 왼쪽 집의수)*k - (오른쪽 집의수)*k
 */
public class 안테나_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> homes = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder()).toList();

        // 현재 안테나 위치
        int current = homes.get(0);

        // 첫번째 집에 안테나를 설치했을 때 거리 합
        int sum = firstSum(homes);

        // 안테나 기준 좌우측 집의 수
        int left = 1;
        int right = homes.size() - left;

        // 집 위치를 이동하면서 거리계산
        for (int i = 1; i < homes.size(); i++) {
            int diff = homes.get(i) - current;
            int sumK = sum + left * diff - right * diff;

            if(sum <= sumK) {
                break;
            } else {
                sum = sumK;
                left++;
                right--;
                current = homes.get(i);
            }
        }

        System.out.println("current = " + current);
    }

    private static int firstSum(List<Integer> homes) {
        // 안테나가 첫번째 집에 있을 때 거리계산
        int dist1 = homes.get(0);

        int sum = 0;
        for(int i=1; i<homes.size(); i++) {
            sum += (homes.get(i) - dist1);
        }
        return sum;
    }
}
