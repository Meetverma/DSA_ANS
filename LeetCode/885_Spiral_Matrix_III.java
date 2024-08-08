// Time Complexity: O(n^2)
// Space Complexity: O(N);

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] result = new int[rows * cols][2];
        

        int[] dX = {0, 1, 0, -1}; // right, down, left, up
        int[] dY = {1, 0, -1, 0}; 
        

        int r = rStart, c = cStart;
        int direction = 0; // Start facing east
        int step = 1; // Initial step
        int idx = 0; 

        //Add first ele
        result[idx++] = new int[]{r, c};
        

        while (idx < rows * cols) {
            for (int i = 0; i < 2; i++) { // Inc the steps every two directions
                for (int j = 0; j < step; j++) {

                    r += dX[direction];
                    c += dY[direction];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[idx++] = new int[]{r, c};
                        if (idx == rows * cols) {
                            return result; // All cells visited
                        }
                    }
                }
                // Change direction (right -> down -> left -> up)
                direction = (direction + 1) % 4;
            }

            step++;
        }

        return result;
    }
}
