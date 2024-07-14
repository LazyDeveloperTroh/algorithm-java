package d_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 소트인사이드_1427_s5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<Integer> arrays = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());

        arrays.sort((n1, n2) -> {
            if(n1 > n2) return -1;
            else if (n1 == n2) return 0;
            else return 1;
        });

        String result = arrays.stream().map(String::valueOf).reduce((s1, s2) -> s1 + s2).orElse("");
        System.out.println(result);
    }
}
