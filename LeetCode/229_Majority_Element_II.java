// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int first_ele  = Integer.MIN_VALUE, second_ele = Integer.MIN_VALUE;
        int first_f = 0, second_f =0;

        for(int i=0;i<nums.length;i++){
            if(first_f == 0 && second_ele!=nums[i]){
                first_f=1;
                first_ele = nums[i];
            }
            else if(second_f == 0 && first_ele!=nums[i]){
                second_f=1;
                second_ele = nums[i];
            }
            else if(nums[i]==first_ele){
                first_f++;
            }
            else if(nums[i]==second_ele){
                second_f++;
            }
            else{
                second_f--;
                first_f--;
            }
        }
        List<Integer> lst = new ArrayList<>();
        first_f=0;
        second_f=0;
        for(int i = 0 ;i<nums.length;i++){
            if(first_ele == nums[i]) first_f++;
            if(second_ele == nums[i]) second_f++;
        }
        if(first_f> nums.length/3) 
            lst.add(first_ele);
        if(second_f > nums.length/3)
            lst.add(second_ele);
        return lst;
    }
}
