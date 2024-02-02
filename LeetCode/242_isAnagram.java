class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            maps.put(s_arr[i], maps.getOrDefault(s_arr[i], 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            mapt.put(t_arr[i], mapt.getOrDefault(t_arr[i], 0) + 1);
        }
        
        for (char c : maps.keySet()) {
            if (!mapt.containsKey(c) || !maps.get(c).equals(mapt.get(c))) {
                return false;
            }
        }
        
        for (char c : mapt.keySet()) {
            if (!maps.containsKey(c) || !mapt.get(c).equals(maps.get(c))) {
                return false;
            }
        }
        
        return true;
    }
}
