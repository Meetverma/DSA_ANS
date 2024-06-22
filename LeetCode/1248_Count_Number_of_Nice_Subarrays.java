//Time: O(N)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int oddCount = 0, result = 0;
        
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }

            if (count.containsKey(oddCount - k)) {
                result += count.get(oddCount - k);
            }

            count.put(oddCount, count.getOrDefault(oddCount, 0) + 1);
        }
        
        return result;
    }
}
