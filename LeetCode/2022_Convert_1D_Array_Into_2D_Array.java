// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][];
        }
        int ans[][] = new int[m][n];
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cnt == original.length){
                    break;
                }
                ans[i][j] = original[cnt++];
            }

        }
    System.gc();
    return ans;
    }
}
