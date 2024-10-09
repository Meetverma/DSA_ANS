// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int minAddToMakeValid(String s) {
        int open=0,close=0;

        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x == '('){
                open++;
            }
            else if(x == ')' && open>0){
                open--;
            }
            else close++;
        }
    return open+close;
    }
}
