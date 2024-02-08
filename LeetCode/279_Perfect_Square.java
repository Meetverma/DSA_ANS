class Solution {
    public int ans(int n,HashMap<Integer,Integer>map){
                for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE; // 
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                min = Math.min(min, map.getOrDefault(i - sq, Integer.MAX_VALUE) + 1);
            }
            //
            map.put(i, min);
        }
        return map.get(n);
    }
    public int numSquares(int n) {
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,0);
        return ans(n,map);
    }
}
