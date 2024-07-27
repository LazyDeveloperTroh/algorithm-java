package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 문자열뒤집기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList();

        int result0 = numbers.get(0) == 0 ? 0 : 1;
        int result1 = numbers.get(0) == 0 ? 1 : 0;

        for (int i = 1; i < numbers.size(); i++) {
            if(numbers.get(i) != numbers.get(i-1)) {
                if(numbers.get(i) == 0) {
                    result1 ++;
                } else {
                    result0 ++;
                }
            }
        }
        System.out.println("result0 = " + result0);
        System.out.println("result1 = " + result1);
        System.out.println("Math.min(result0, result1) = " + Math.min(result0, result1));
    }
}
