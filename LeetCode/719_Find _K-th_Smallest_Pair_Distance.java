/*
 * Time Complexity: O(N.Log N + Log(max))
 * Time Complexity: O(N)
 * Thanks to NeetCode for the intution 😇.
*/

class Solution {
    public int helper(int diff ,int nums[]){
        int cnt = 0;
        int l = 0;
        
        for(int r=0;r<nums.length;r++){
            while((nums[r]-nums[l]) > diff)
                l++;
            cnt += r-l;

        }
        return cnt;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r= Arrays.stream(nums).max().getAsInt();

        while(l<r){
            int mid = (l + r) /2 ;
            int pairs = helper(mid,nums);
            if(pairs >= k ){
                r= mid;
            }else{
                l=mid+1;
            }
        }
    return r;
    }
}
