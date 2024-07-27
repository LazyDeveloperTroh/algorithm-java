package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 럭키스트레이트_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toList();

        int left = 0;
        int right = 0;
        for(int i=0; i<numbers.size(); i++) {
            if(i < numbers.size()/2) {
                left += numbers.get(i);
            } else {
                right += numbers.get(i);
            }
        }

        String result = left == right ? "LUCKY" : "READY";
        System.out.println("result = " + result);
    }
}
