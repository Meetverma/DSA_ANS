import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> temp = new ArrayList<>();
        int llen = Integer.toString(low).length();
        int hlen = Integer.toString(high).length();

        for (int i = llen; i <= hlen; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                int num = gen(j, i);
                if (num >= low && num <= high) {
                    temp.add(num);
                }
            }
        }

        Collections.sort(temp); // Sort the list before returning
        return temp;
    }

    public int gen(int start, int len) {
        int num = start;
        for (int i = 1; i < len; i++) {
            num = num * 10 + (start + i);
        }
        return num;
    }
}
