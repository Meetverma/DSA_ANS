// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int minLength(String s) {
        StringBuilder str = new StringBuilder(s);
        Stack<StringBuilder> stk = new Stack();
        stk.push(str);
        int n=str.length();
        while(!stk.isEmpty()){
            StringBuilder temp = stk.pop();
            n = temp.length();
            if(temp.toString().contains("AB")){
                int idx = temp.indexOf("AB");
                temp = temp.delete(idx,idx+2);

                stk.push(temp);
            }else if(temp.toString().contains("CD")){
                int idx = temp.indexOf("CD");
                temp = temp.delete(idx,idx+2);

                stk.push(temp);
            }
        }
    return n;
    }
}
