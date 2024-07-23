package b_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트_이코테 {
    public static void main(String[] args) throws IOException {
        int[] dx = {2, 2, -2, -2, 1, -1, -1, 1};
        int[] dy = {1, -1, 1, -1, -2, -2, 2, 2};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputs = br.readLine();
        int row = Integer.valueOf(inputs.charAt(1)+"")-1;
        int column = inputs.charAt(0) - 'a';

        int result = 0;
        for (int k = 0; k < 8; k++) {
            int nx = column + dx[k];
            int ny = row + dy[k];

            if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
                result++;
            }
        }
        System.out.println("result = " + result);
    }
}
