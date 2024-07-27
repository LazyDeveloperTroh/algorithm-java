package b_implement.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 그룹단어체커_1316_s5 {
    public static boolean isGroupChar(String str) {
        char[] chars = str.toCharArray();

        Set<Character> chartSet = new HashSet<>();
        for (int j = 1; j < chars.length; j++) {
            if(chars[j] != chars[j-1]) {
                if(!chartSet.contains(chars[j])) {
                    chartSet.add(chars[j-1]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            boolean isGroupChar = isGroupChar(input);

            if(isGroupChar) {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
