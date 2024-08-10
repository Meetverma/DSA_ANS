// Time Complexity: O(N)
//  Space Complexity: O(1)

class Solution {
    
    public int maxJump(int[] stones) {
        int n = stones.length;
        int temp = stones[1] - stones[0];
        
        // potential jump from 0th to first stone

        for(int i = 1;i<n-1;i++){
            temp = Math.max(temp,stones[i+1]-stones[i-1]);
        }    //get the biggest jump
        return temp;
        }
}
