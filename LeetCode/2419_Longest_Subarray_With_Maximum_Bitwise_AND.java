class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxEle = Arrays.stream(nums).max().getAsInt();

        int maxSoFar=0;
        int size=0;
        int i=0;
        int j=0;
        while(i<n && j<n){
            if(nums[i++] == maxEle){
                size++;
                maxSoFar = Math.max(maxSoFar,size);
                for(j = i;j<n;j++){
                    if( nums[j] == maxEle){
                        size++;
                        maxSoFar = Math.max(size,maxSoFar);
                    }
                    else{
                        size=0;
                        i=j;
                        break;
                    }
                }
            }
        }
    return maxSoFar;
    }
}
