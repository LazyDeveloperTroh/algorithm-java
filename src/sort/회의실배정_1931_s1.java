package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 회의실배정_1931_s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        List<ReserveTime> reserves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ReserveTime reserve = new ReserveTime(start, end);
            reserves.add(reserve);
        }

        reserves = reserves.stream()
                .sorted(Comparator.comparing(ReserveTime::getEnd)
                        .thenComparing(ReserveTime::getStart))
                .collect(Collectors.toList());
        int end = reserves.get(0).getEnd();
        int result = 1;
        for (int i = 1; i < reserves.size(); i++) {
            ReserveTime reserveTime = reserves.get(i);
            if(reserveTime.getStart() >= end) {
                end = reserveTime.getEnd();
                result++;
            }
        }

        System.out.println(result);
    }

    static class ReserveTime {
        private int start;
        private int end;

        public ReserveTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
        @Override
        public String toString() {
            return "start: " + start + ", end: " + end;
        }
    }
}
