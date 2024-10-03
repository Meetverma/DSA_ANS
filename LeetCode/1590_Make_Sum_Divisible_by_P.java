// Thanks to NeedCode for the intution

class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long total_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            total_sum += nums[i];
        }

        int r = (int) (total_sum % p);

        if (r == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        long cur_sum = 0;
        map.put(0, -1);  

        for (int i = 0; i < nums.length; i++) {
            cur_sum = (cur_sum + nums[i]) % p;
            if (cur_sum < 0) {
                cur_sum += p;
            }

            int prefix_to_remove = (int) ((cur_sum - r + p) % p);
            if (map.containsKey(prefix_to_remove)) {
                int len = i - map.get(prefix_to_remove);
                ans = Math.min(ans, len);
            }
            map.put((int) cur_sum, i);
        }

        return (ans == Integer.MAX_VALUE || ans == nums.length) ? -1 : ans;
    }
}
