package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 큰수의법칙2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n 배열의 크기, m 몇번 더할지, k 같은 인덱스 더하는 횟수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] array = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int result = 0;
        int tmp = k;
        while(m > 0) {
            if(tmp > 0) {
                result += array[0];
            } else {
                // 가장 큰 인덱스를 k번 더했다면 두번째로 큰 인덱스를 더함, k 초기화
                tmp = k;
                result += array[1];
            }
            // 같은 인덱스 연산횟수 차감
            tmp -= 1;
            m -= 1;
        }
        System.out.println("result = " + result);
    }
}
