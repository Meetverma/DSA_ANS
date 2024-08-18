// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {
    public int helper(int idx, int nums[], int dp[]) {
        if (idx == nums.length - 1) {
            return 0;
        }
        if (idx >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int mini = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[idx]; j++) {
            int nextIdx = j + idx;
            int temp = helper(nextIdx, nums, dp);
            if (temp != Integer.MAX_VALUE) {
                temp = temp + 1;
            }
            mini = Math.min(temp, mini);

        }
        dp[idx] = mini;
        return mini;
    }

    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}
