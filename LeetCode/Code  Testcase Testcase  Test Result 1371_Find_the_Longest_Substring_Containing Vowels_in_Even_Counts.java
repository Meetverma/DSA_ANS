// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int findTheLongestSubstring(String s) {
        String v = "aeiou";
        int ans = 0;

        HashMap<Integer, Integer> bitmask = new HashMap<>();
        int mask = 0;
        bitmask.put(0,-1);

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(v.contains(ch+"")){
                mask ^= (1 << ch-'a');
            }
            if(bitmask.containsKey(mask)){
                ans = Math.max(ans, i-bitmask.get(mask));
            }else{
                bitmask.put(mask,i);
            }
        }

    return ans;
    }
}
