package e_search.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 숫자카드_10815_s5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> cards = Arrays.stream(br.readLine().split(" "))
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());
        List<Integer> targets = Arrays.stream(br.readLine().split(" "))
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());

        cards.sort(Comparator.naturalOrder());
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<targets.size(); i++) {
            int target = targets.get(i);
            int result = binary_search(cards, target, 0, cards.size()-1) == -1 ? 0 : 1;
            results.add(result);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.printf(results.get(i)+" ");
        }
    }

    private static int binary_search(List<Integer> cards, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(target == cards.get(mid)) return mid;
        else if(target > cards.get(mid)) return binary_search(cards, target, mid+1, end);
        else return binary_search(cards, target, start, mid - 1);
    }
}
