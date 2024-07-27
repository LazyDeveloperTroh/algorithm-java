package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 두배열의원소교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arrayA = new Integer[n];
        Integer[] arrayB = new Integer[n];

        Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList().toArray(arrayA);
        Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList().toArray(arrayB);

        Arrays.sort(arrayA, Comparator.naturalOrder());
        Arrays.sort(arrayB, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            int temp = arrayA[i];
            arrayA[i] = arrayB[i];
            arrayB[i] = temp;
        }

        int result = Arrays.stream(arrayA).mapToInt(i -> i).sum();
        System.out.println("result = " + result);
    }
}
