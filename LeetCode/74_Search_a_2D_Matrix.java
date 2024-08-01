// Time Complexity: O(log(m*n))
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i =0;i<m;i++){
            if(target >= matrix[i][0] && target<= matrix[i][n-1]){
                int high=n-1,low = 0;
                while(high>=low){
                    int mid = (high+low)/2;
                    if(target == matrix[i][mid])
                        return true;

                    if(target < matrix[i][mid]){
                        high = mid-1;
                    }
                    if(target > matrix[i][mid] ){
                        low = mid+1;
                    }
                }
            }
        }
    return false;
    }
}
