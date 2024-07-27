package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 곱하기혹은더하기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList();

        int result = numbers.get(0);
        for(int i=1; i<numbers.size(); i++) {
            if(result == 0 || numbers.get(i) == 0) {
                result += numbers.get(i);
            } else {
                result *= numbers.get(i);
            }
        }

        System.out.println("result = " + result);
    }
}
