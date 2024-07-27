package a_greedy.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거스름돈_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] money = {10, 50, 100, 500};
        Arrays.sort(money, Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<money.length; i++) {
            result += (n / money[i]);
            n = n % money[i];
        }

        System.out.println(result);
    }
}
