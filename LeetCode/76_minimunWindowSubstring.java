// sliding window protocol used 
// 2 pointer approach

class Solution {
    public String minWindow(String s, String t) {
                if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        
        String ans = "";

        for (char c : t_char) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int left = 0, minLen = Integer.MAX_VALUE, count = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s_char[right];

            if (tmap.containsKey(rightChar)) {
                smap.put(rightChar, smap.getOrDefault(rightChar, 0) + 1);
                if (smap.get(rightChar) <= tmap.get(rightChar)) {
                    count++;
                }
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                } // check for each loop for the minimum wondow size 

                char leftChar = s_char[left];

                if (tmap.containsKey(leftChar)) {
                    smap.put(leftChar, smap.get(leftChar) - 1);
                    if (smap.get(leftChar) < tmap.get(leftChar)) {
                        count--;
                    }
                }

                left++;
            }
        }

        return ans;
    }
}
