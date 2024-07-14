package a_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.valueOf(br.readLine()));
        }

        int result = 0;
        for(int i=coins.size()-1; i >= 0; i--) {
            int coin = coins.get(i);
            if(k >= coin) {
                int cnt = (k / coin);
                k -= (cnt * coin);
                result += cnt;
            }

            if(k == 0) {
                break;
            }
        }
        System.out.println(result);
    }
}
