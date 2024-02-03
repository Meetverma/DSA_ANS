class Solution {
    public void reverseString(char[] s) {
        int first = 0 , last = s.length-1;

        while(first==last || first<last){
            char temp;
            temp=s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }
}
