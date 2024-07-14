package b_implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 셀프넘버_4673_s5 {
    public static int makeDn(int n) {
        int result = n;

        while(n > 0) {
            result += (n%10);
            n /= 10;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> dnList = new ArrayList<>();

        for(int i=1; i<10000; i++) {
            int dn = makeDn(i);
            dnList.add(dn);
        }

        for (int i = 1; i <= 10000; i++) {
            if(!dnList.contains(i)) {
                System.out.println(i);
            }
        }
    }
}
