/*
  1. Sort and assign 3 values to each n/3 sub-array 
  2. If the absolute difference between the 1st ans the 3rd number in array is>k
      return empty array
      Time Complexity: O(nlogn) + O(n) => Sorting + loop 
*/
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int temp [][] = new int[100][100];
        Arrays.sort(nums);
        int Bigidx = 0 ;

        for(int i=0;i<nums.length();i++){
            if(Math.abs(nums[i],nums[i+2])<=k){
                temp[Bigdata++][i%3]=nums[i];
            }
            else return new int [][];
        }
    }
}
