// Time Complexity: O(log(N)) : N=target
// Space Complexity: O(1)

class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles == 0){
            return 1*target -1;
        }
        int x = target ;
        int steps =0;

        while(maxDoubles>=1 && x>1){
            if(x%2==0){
            steps++;
            maxDoubles--;
            x= x/2;
            }
            else{
                steps++;
                x--;
            }
        }

        steps+=x-1;

   return steps;
   }
}
