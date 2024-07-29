// Time Complexity: O(n^2)
// Spcae Complexity: O(1)

class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int j =0;j<rating.length;j++){
            int bl=0,br=0,sl=0,sr=0;
            for(int i=j-1;i>=0;i--){
                if(rating[i]>rating[j]){
                    bl++;
                }
                else{
                    sl++;
                }
            }
            for(int k=j+1;k<rating.length;k++){
                if(rating[k]>rating[j]){
                    br++;
                }
                else{
                    sr++;
                }
            }
            ans+= br*sl + sr*bl;
        }
        return ans;
    }
}
