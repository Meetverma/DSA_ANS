// Time Complexity: O(N)
//Space Complexity: O(1)
//Kadane's Algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int cur_sum = 0;
        for(int ele: nums){
            cur_sum = Integer.max(cur_sum,0);
            cur_sum += ele;
            max_sum = Integer.max(max_sum,cur_sum);
        }
        return max_sum;
    }
}
