package x_math.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntEntrapment_9298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Double minX = null, minY = null;
            Double maxX = null, maxY = null;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                minX = minX == null ? x : Math.min(minX, x);
                maxX = maxX == null ? x : Math.max(maxX, x);
                minY = minY == null ? y : Math.min(minY, y);
                maxY = maxY == null ? y : Math.max(maxY, y);
            }
            double area = (maxX - minX) * (maxY - minY);
            double perimeter = (maxX - minX)*2 + (maxY - minY)*2;

            String result = String.format("Case %d: Area %f, Perimeter %f", i + 1, area, perimeter);
            System.out.println(result);
        }

    }
}
