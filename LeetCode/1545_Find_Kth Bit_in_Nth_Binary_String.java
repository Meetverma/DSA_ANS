// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    private StringBuffer invert(StringBuffer num){
        for(int i=0;i<num.length();i++){
            if(num.charAt(i) == '0'){
                num.setCharAt(i,'1');
            }else{
                num.setCharAt(i,'0');
            }
        }
    return num;
    }
    public char findKthBit(int n, int k) {

        StringBuffer num = new StringBuffer("0");

        StringBuffer temp = new StringBuffer();

        for(int i=1;i<n;i++){
            temp.setLength(0);
            temp.append(num);
            StringBuffer inverted = invert(temp);
            num.append("1");
            num.append( inverted.reverse() ); 
        }
        return num.charAt(k-1);
    }
}
