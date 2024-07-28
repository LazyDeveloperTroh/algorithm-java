package d_sort.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 프레이어 수
 * 2. 각 스테이지 리스트에 도전중인 플레이어수를 저장한다. (최대 20만번 계산)
 * 3. 전체 플레이어수를 구한다. ( = states 길이)
 * 4. 1번 스테이지부터 실패율을 계산한다.(최대 500번 계산)
 *     - 2번스테이지의 도달한 플레이어 수는 (전체 플레이어수 - 1번 스테이지에 도전중인 플레이어 수)
 *     - 3번스테이지의 도달한 플레이어 수는 (전체 플레이어수 - 1,2번 스테이지에 도전중인 플레이어 수)
 */
public class 실패율_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> stages = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

        int[] stageInPlayers = new int[n + 2];
        for(int i=0; i<stages.size(); i++) {
            stageInPlayers[stages.get(i)]++;
        }

        int totalPlayers = stages.size();
        List<StageFailRate> failRates = new ArrayList<>();
        for (int i = 1; i < stageInPlayers.length-1; i++) {
            int player = stageInPlayers[i];
            double failRate = (double) player / totalPlayers;
            failRates.add(new StageFailRate(i, failRate));
            totalPlayers -= player;
        }

        failRates.sort((o1, o2) -> {
            if(o1.failRate > o2.failRate) {
                return -1;
            } else if(o1.failRate < o2.failRate) {
                return 1;
            } else {
                if(o1.stage > o2.stage) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < failRates.size(); i++) {
            System.out.println(failRates.get(i).stage);
        }
    }

    static class StageFailRate {
        private int stage;
        private double failRate;

        public StageFailRate(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }
    }
}
