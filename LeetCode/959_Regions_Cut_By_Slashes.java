// approach : the question is similar to find the number of islands which was dont using dfs...
// here we convert the grid into 3x3 matrix and start the dfs from the array index which is empty
// then the structure of the code remains the same as in number of islands 
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {
    public void dfs(int [][]matrix,int r,int c){
        int n = matrix.length;

        if(r<0 || r>=n || c<0 || c>=n || matrix[r][c] != 0){
            return;
        }
        matrix[r][c] =-1;
        dfs(matrix,r-1,c);
        dfs(matrix,r+1,c);
        dfs(matrix,r,c-1);
        dfs(matrix,r,c+1);
    }
    public int regionsBySlashes(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        int matrix[][] = new int[r*3][c*3];

        for(int i=0;i<r;i++){
            String s = grid[i];
            for(int j=0;j<c;j++){
                char cur = s.charAt(j);
                if(cur == '/'){
                    matrix[i*3][j*3+2] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3] = 1;
                }
                else if(cur == '\\'){
                    matrix[i*3][j*3] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3+2] = 1;
                }
            }

        }
        int cnt = 0;
            for(int i=0;i<r*3;i++){
                for(int j=0;j<c*3;j++){
                    if(matrix[i][j] == 0){
                        dfs(matrix, i , j);
                        cnt++;
                    }
                }
            }
            return cnt;
    }
}
