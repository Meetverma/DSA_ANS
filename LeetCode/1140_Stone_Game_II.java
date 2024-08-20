// Time Complexity: O(N^3)
// Spcae Complexity: O(N^3)

import java.util.HashMap;

class Solution {
    public int helper(boolean turn, int M, int idx, int piles[], HashMap<String, Integer> map) {
        if (idx >= piles.length) {
            return 0;
        }
        if (map.containsKey("" + turn + "," + idx + "," + M)) {
            return map.get("" + turn + "," + idx + "," + M);
        }
        int ans = turn ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0; i < 2 * M; i++) {
            if ((i + idx) >= piles.length) {
                break;
            }
            total += piles[idx + i];
            if (turn) { // Alice's turn
                ans = Math.max(ans, total + helper(!turn, Math.max(M, i + 1), i + idx + 1, piles, map));
            } else { // Bob's turn
                ans = Math.min(ans, helper(!turn, Math.max(M, i + 1), i + idx + 1, piles, map));
            }
        }
        map.put("" + turn + "," + idx + "," + M, ans);
        return ans;
    }

    public int stoneGameII(int[] piles) {
        HashMap<String, Integer> map = new HashMap<>();
        return helper(true, 1, 0, piles, map);
    }
}
