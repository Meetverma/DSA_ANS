// Time Complexity: O(N)
// Greedy Approach: assuimg all bits to be 1 before i 

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips=0;
        Queue<Integer> f = new LinkedList<>();

    for(int i=0;i<nums.length;i++){

        while( !f.isEmpty() && i > f.peek()+k-1 )
            f.remove();

        if( ( nums[i] + f.size() ) % 2 == 0){
            if((i+k)>nums.length){
                return -1;
            }
            else{
                flips++;
                f.add(i);
            }
        }
    }


    return flips;   
    }
}
