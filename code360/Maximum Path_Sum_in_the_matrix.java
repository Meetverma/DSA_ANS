// Time Complexity: O(N*M)
// Space Complexity: O(M) for N x M matrix

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

		int front[] = new int[m];
		int cur[] = new int[m];
        
        for (int j = 0; j < m; j++) {
            front[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + front[j];
                
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;

                if (j - 1 >= 0) {
                    ld = matrix[i][j] + front[j-1];
                }

                if (j + 1 < m) {
                    rd = matrix[i][j] + front[j+1];
                }

                cur[j] = Math.max(up, Math.max(ld, rd));
            }
			front = cur.clone();
        }

        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, front[j]);
        }

        return maxi;
    }
}
