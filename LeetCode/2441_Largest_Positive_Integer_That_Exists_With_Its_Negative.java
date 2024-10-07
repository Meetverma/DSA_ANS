// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        while( l < nums.length){
            int r = nums.length-1;

            while(r>l){
                if(nums[l] == nums[r]*-1 ){
                    return nums[r];
                }
                r--;
            }
            l++;
        }
    return -1;
    }
}
