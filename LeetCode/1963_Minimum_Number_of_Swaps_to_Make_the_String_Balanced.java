// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int minSwaps(String s) {
        int temp= 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '['){
                temp++;
            }
            else if(temp>0){
                temp--;
            }
        }
        return (temp+1)/2;
    }
}
