package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 여러개 조건으로 정렬(국어점수 내림차순, 영어점수 오름차순, 수학점수 내림차순, 이름 사전순(오름차순))
 * 2. Comaprator 객체의 revered() 메서드는 리스트 전체를 바꿔버리기 때문에 순서에 유의해서 사용해야 한다 -> 이와 같은 이유로 사용안함
 * 3. Comparator 를 직접 구현(return 이 1이면 왼쪽이 오른쪽으로, -1이면 왼쪽이 왼쪽으로, 0이면 같다)
 */
public class 국영수_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<PersonScore> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());

            scores.add(new PersonScore(name, koreanScore, englishScore, mathScore));
        }
        scores.sort(Comparator.comparing(PersonScore::getEnglishScore).reversed());

        Collections.sort(scores, ((o1, o2) -> {
            if(o1.koreanScore > o2.koreanScore) {
                return -1;
            } else if(o1.koreanScore < o2.koreanScore) {
                return 1;
            } else {
                if(o1.englishScore > o2.englishScore) {
                    return 1;
                } else if(o1.englishScore < o2.englishScore) {
                    return -1;
                } else {
                    if(o1.mathScore > o2.mathScore) {
                        return -1;
                    } else if(o1.mathScore < o2.mathScore) {
                        return 1;
                    } else {
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
        }));

        for (int i = 0; i < scores.size(); i++) {
            System.out.println(scores.get(i));
        }
    }

    static class PersonScore{
        private String name;
        private int koreanScore;
        private int englishScore;
        private int mathScore;

        public PersonScore(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public String toString() {
            return "PersonScore{" +
                    "name='" + name + '\'' +
                    ", koreanScore=" + koreanScore +
                    ", englishScore=" + englishScore +
                    ", mathScore=" + mathScore +
                    '}';
        }

        public String getName() {
            return name;
        }

        public int getKoreanScore() {
            return koreanScore;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }

    }
}
