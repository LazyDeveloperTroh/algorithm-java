package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 성적이낮은순서로학생출력하기_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            students.add(new Student(name, score));
        }

        students.sort(Comparator.naturalOrder());
        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).name+" ");
        }
    }

    static class Student implements Comparable{
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Object o) {
            Student s = (Student) o;
            return score - s.score;
        }
    }
}
