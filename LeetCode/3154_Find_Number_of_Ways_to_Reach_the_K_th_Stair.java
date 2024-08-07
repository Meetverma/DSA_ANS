// Time Complexity:
// Space Complexity: 

class Solution {

    public int helper(int k, int idx, boolean consecutive, int jump, HashMap<String, Integer> memo) {
        if (idx < 0 || idx>k+1) {
            return 0;
        }
        int ways = 0;
        if (idx == k) {
            ways++; 
        }

        String key = idx + "," + consecutive + "," + jump;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (idx > 0 && !consecutive) {
            ways+=helper(k, idx - 1, true, jump, memo);
        }

        ways += helper(k, idx + (1 << jump), false, jump + 1, memo);

        memo.put(key, ways);
    return ways;
    }

    public int waysToReachStair(int k) {
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(k, 1, false, 0, memo);

    }
    
}
