class Solution {
    public int find(int nums[],int idx,int prev_idx,int dp[][],int n){

        if(idx==n){
            return 0;
        }
        if(dp[idx][prev_idx+1]!=-1)
            return dp[idx][prev_idx+1];

        int len = 0 + find(nums ,idx+1,prev_idx,dp,n); // not considering the idx'th element

        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            len = Math.max(len,1 + find(nums, idx+1,idx,dp,n));
            // dp[idx][prev_idx+1]=len;
        }
        return dp[idx][prev_idx+1]=len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n+1];
        for (int i = 0; i <n ; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(nums,0,-1,dp,n);
    }
}
