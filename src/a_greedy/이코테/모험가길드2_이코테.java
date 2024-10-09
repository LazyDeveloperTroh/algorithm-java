package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 모험가길드2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> users = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().toList();

        int cnt = 0;
        int result = 0;
        for(int u : users) {
            cnt ++;

            if (cnt >= u) {
                result ++;
                cnt = 0;
            }
        }

        System.out.println("result = " + result);
    }
}
