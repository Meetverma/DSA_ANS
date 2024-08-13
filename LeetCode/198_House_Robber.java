// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public int helper(int idx, int []nums,int dp[]){
        if(idx < 0){
            return 0;
        }   
        if(idx == 0){
            return nums[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        int pick = nums[idx] + helper(idx-2,nums,dp);
        int npick = helper(idx-1,nums,dp);
        dp[idx] = Math.max(pick,npick);
        return dp[idx];

    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
}
