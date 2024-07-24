package d_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 위에서아래로_이코테 {
    private static final int MAX_NUMBER =100000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] arrays = new int[100001];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arrays[num] += 1;
        }

        for (int i = MAX_NUMBER; i >= 0; i--) {
            for (int j = 0; j < arrays[i]; j++) {
                System.out.printf(String.valueOf(i)+" ");
            }
        }
    }
}
