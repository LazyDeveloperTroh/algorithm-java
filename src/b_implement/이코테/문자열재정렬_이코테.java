package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열재정렬_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");

        String charactors = "";
        int numbers = 0;
        for (int i = 0; i < inputs.length; i++) {
            if(inputs[i].matches("\\d")) {
                numbers += Integer.parseInt(inputs[i]);
            } else {
                charactors += inputs[i];
            }
        }

        charactors = Arrays.stream(charactors.split(""))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(""));
        String result = charactors + numbers;
        System.out.println("result = " + result);
    }
}
