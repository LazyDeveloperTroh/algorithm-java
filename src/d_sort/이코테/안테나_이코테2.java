package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 안테나_이코테2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> houses = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).sorted().toList();

        int leftCnt = 0;
        int leftSum = 0;
        int rightCnt = houses.size()-1;
        int rightSum = houses.stream().mapToInt(x -> x).sum() - houses.get(0) - rightCnt * houses.get(0);
        int min = leftSum + rightSum;
        int result = houses.get(0);
        for (int i = 1; i < houses.size(); i++) {
            int diff = houses.get(i) - houses.get(i - 1);
            leftCnt += 1;
            leftSum += (diff) * leftCnt;

            rightSum -= (diff) * rightCnt;
            rightCnt -= 1;

            int newDist = leftSum + rightSum;
            if(newDist < min) {
                result = houses.get(i);
                min = newDist;
            }
        }

        System.out.println("result = " + result);
    }
}
