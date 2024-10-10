package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트2_이코테 {
    private static int[] dx = {2, 2, -2, -2, -1, 1, -1, 1};
    private static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");

        int x = (int) (inputs[0].charAt(0) - 'a')+1;
        int y = Integer.parseInt(inputs[1]);

        int result = 0;
        for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx < 1 || nx > 8 || ny < 1 || ny > 8) {
                continue;
            }
            result++;
        }
        System.out.println("result = " + result);
    }
}
