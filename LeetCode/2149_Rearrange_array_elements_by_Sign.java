// Time complexity: O(n);

class Solution {
    public int[] rearrangeArray(int[] nums) {
            int nve[]= new int[nums.length/2];
        int pve[] = new int[nums.length/2];
        int n=0,p=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0)
                nve[n++]=nums[i];
            else
                pve[p++]=nums[i];
        }
            
        n=0;
        p=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                nums[i]=pve[p++];
            else
                nums[i]=nve[n++];

        }
        return nums;
    }
}
