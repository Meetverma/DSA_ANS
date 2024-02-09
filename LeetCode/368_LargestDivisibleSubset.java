class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n==0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[n];
        int pr[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(pr,-1);

        int max_ele=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1 ){
                    pr[i]=j;
                    dp[i]=dp[j]+1;
                    if(dp[i]>dp[max_ele])
                        max_ele=i;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (max_ele >= 0) {
            // System.out.print(max_ele);
            ans.add(nums[max_ele]);
            max_ele= pr[max_ele];
        }
    return ans;
    }
}
