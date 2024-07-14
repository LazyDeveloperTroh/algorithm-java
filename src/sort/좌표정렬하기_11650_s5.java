package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬하기_11650_s5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            points.add(new Point(v1, v2));
        }

//        points.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        points.sort((o1, o2) -> {
            if (o1.getX() > o2.getX()) return 1;
            else if (o1.getX() < o2.getX()) return -1;
            else {
                if (o1.getY() > o2.getY()) return 1;
                else if (o1.getY() < o2.getY()) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            System.out.println(p.getX()+" "+p.getY());
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
