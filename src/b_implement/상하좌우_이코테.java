package b_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상하좌우_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        String[] inputs = br.readLine().split(" ");
        int x = 0;
        int y = 0;
        for (int i = 0; i < inputs.length; i++) {
            String move = inputs[i];

            switch (move) {
                case "L":
                    x = x > 0 ? x - 1 : x;
                    break;
                case "R":
                    x = x < n ? x + 1 : x;
                    break;
                case "U":
                    y = y > 0 ? y - 1 : y;
                    break;
                case "D":
                    y = y < n ? y + 1 : y;
                    break;
            }
        }
        System.out.println((y+1)+" "+(x+1));
    }
}
