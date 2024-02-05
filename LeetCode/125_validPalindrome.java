/*
1. convert non-alphanumeric stirng to alphanumeric 
2. push the string 
3. pop and compare making both the charaters to lowercase
Time Complexity: O(n)
*/

class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stk = new Stack<>();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        int n = s.length();

        for (int i = 0; i < n; i++) {
            stk.push(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            char popped = stk.pop();
            if (s.charAt(i) != popped) {
                return false;
            }
        }

        return true;
    }
}
