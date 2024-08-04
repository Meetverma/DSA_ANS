// Moore's Voting Algorithm for majority element occuring more than N/2 times 
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {
    int ele = nums[0];
    int count = 0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==ele)
            count++;
        else if(nums[i]!=ele && count==0){
            ele = nums[i];
            count++;
        }
        else count--;
    }
    return ele;
    }
}
