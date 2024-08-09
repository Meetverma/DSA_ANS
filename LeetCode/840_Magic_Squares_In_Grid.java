class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagic(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        int[] row_sum = new int[3];
        int[] col_sum = new int[3];
        int diag_lr = 0;
        int diag_rl = 0;
        Set<Integer> appeared = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[r+i][c+j];
                if (val < 1 || val > 9) {
                    return false;
                }
                appeared.add(val);
                row_sum[i] += val;
                col_sum[j] += val;
                if (i == j) {
                    diag_lr += val;
                }
                if (i + j == 2) {
                    diag_rl += val;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (row_sum[i] != 15 || col_sum[i] != 15) {
                return false;
            }
        }
        return appeared.size() == 9 && diag_lr == 15 && diag_rl == 15;
    }
}
