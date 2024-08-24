package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수2_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<StudentScore> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            scores.add(new StudentScore(name, korean, english, math));
        }

        Comparator<StudentScore> studentScoreComparator = (o1, o2) -> {
            // 국어점수 정렬
            if(o1.korean < o2.korean) {
                return 1;
            } else if(o1.korean > o2.korean) {
                return -1;
            } else {
                // 영어 점수 정렬
                if(o1.english < o2.english) {
                    return -1;
                } else if(o1.english > o2.english) {
                    return 1;
                } else {
                    // 수학 점수 정렬
                    if(o1.math < o2.math) {
                        return 1;
                    } else if(o1.math > o2.math) {
                        return -1;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
        };
        scores.sort(studentScoreComparator);

        for(StudentScore score : scores) {
            System.out.println(score.name);
        }
    }

    static class StudentScore {
        private String name;
        private int korean;
        private int english;
        private int math;

        public StudentScore(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
