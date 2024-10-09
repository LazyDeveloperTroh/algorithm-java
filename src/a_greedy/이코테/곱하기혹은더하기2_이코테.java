package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 곱하기혹은더하기2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList();

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int n = numbers.get(i);

            if(result == 0 || n == 0 || result == 1 || n == 1) result += n;
            else result *= n;
        }

        System.out.println("result = " + result);
    }
}
