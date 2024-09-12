// Time Complexity: O(words.length)
// Space Complexity: O(1) -> auxilary space

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            String s = words[i];
            boolean temp = false;
            for(int j=0;j<s.length();j++){
                if(allowed.contains(String.valueOf(s.charAt(j))) ){
                    temp = true;
                }
                else{
                    temp = false;
                    break;
                }
            }
            if(temp){
                cnt++;
            }
        }
    return cnt;
    }
}
