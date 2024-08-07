// Time Complexity: O(n) 
// Space Complexity: O(n)
class Solution {
    public int helper(int n,HashMap<Integer,Integer>map){
        if(map.containsKey(n))
            return map.get(n); 
        if(n == 1)
            return 1;
        if(n == 0)
            return 0;
        int r = helper(n-1,map) + helper(n-2,map);
        map.put(n,r);
        return r ;
    }
    public int fib(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        return helper(n,map);
    }

}
