// Time Complexity: O(n)
// Space Complexity: O(128) ~O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count[] = new int[128];
        int left=0;
        int longestTillNow = 0;

        for(int right = 0;right<s.length();right++){
            count[s.charAt(right)]++;

            while(count[s.charAt(right)]>1){
                count[s.charAt(left)] --;
                left++;
            }
            longestTillNow = Math.max(longestTillNow,right-left+1);
        }
        return longestTillNow;
    }
}
