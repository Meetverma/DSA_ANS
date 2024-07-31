// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public int helperFn(int n, int i, int books[][], int shelfWidth, int dp[]) {
        if (i == n)
            return 0;
        
        if (dp[i] != -1) 
            return dp[i];
        
        int cur_width = shelfWidth;
        int min_height = Integer.MAX_VALUE;
        int cur_max_height = 0;

        for (int j = i; j < n; j++) {
            int w = books[j][0];
            int h = books[j][1];

            if (cur_width < w) {
                break;
            }
            cur_width -= w;
            cur_max_height = Math.max(cur_max_height, h);

            min_height = Math.min(min_height, helperFn(n, j + 1, books, shelfWidth, dp) + cur_max_height);
        }
        
        return dp[i] = min_height;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helperFn(n, 0, books, shelfWidth, dp);
    }
}
