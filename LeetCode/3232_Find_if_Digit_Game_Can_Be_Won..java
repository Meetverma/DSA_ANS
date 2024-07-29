// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleSum=0,doubleSum=0;

        for(int i=0;i<nums.length;i++ ){
            if( nums[i]%10 == nums[i] ){ // single sum
                singleSum+=nums[i];
            }
            else{
                doubleSum+=nums[i];
            }
        }
        if(doubleSum == singleSum )
            return false;
        return true;
    }
}
