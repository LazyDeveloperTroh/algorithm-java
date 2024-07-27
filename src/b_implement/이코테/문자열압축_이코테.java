package b_implement.이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축_이코테 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 1. 길이를 1부터 length-1까지 자르면서 압축해본다.
        // 2. 각 압축 결과를 이전 결과와 비교해서 갱신한다.

        for(int i=1; i<=input.length()/2; i++) {
            String temp = input;
            String before = "";
            String tempResult = "";
            int cnt = 0;
            while(temp.length() > 0) {
                // 더이상 자를 수 없을 때 남은 부분을 tempResult에 저장
                if(temp.length() < i) {
                    tempResult += temp;
                    break;
                }

                // i 크기만큼 자르기
                String s = temp.substring(0, i);
                if(before.equals("")) {
                    before = s;
                    temp = temp.substring(i, temp.length());
                    cnt = 1;
                    continue;
                }

                // 이전값과 같은 경우, cnt 증가
                if(s.equals(before)) {
                    cnt++;
                } // 이전값과 다른 경우 tempResult 에 저장
                else {
                    if(cnt > 1) tempResult += (before + cnt);
                    else tempResult += before;
                    cnt = 1;
                    before = s;
                }

                temp = temp.substring(i, temp.length());
                if(temp.equals("") ) {
                    if(cnt > 1) tempResult += (s + cnt);
                    else tempResult += s;
                }
            }
            System.out.println("tempResult = " + tempResult+" size="+i);
        }
    }
}
