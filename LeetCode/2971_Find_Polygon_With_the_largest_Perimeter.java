class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums); //ascending order
        int n = nums.length;
        int idx_ak = n-1;//current largest side of the polygon;
        // int i=0;
        long para=0;  
        while(idx_ak>1){
        for(int i=0;i<idx_ak;i++){
            para+=nums[i];
            if(nums[idx_ak]<para && i==idx_ak-1)
                return (long)(para+nums[idx_ak]);
            }    
        idx_ak--;
        para=0;
        }
        return -1;
    }
}
