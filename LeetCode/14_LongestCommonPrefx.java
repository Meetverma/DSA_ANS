class Solution {
    public String longestCommonPrefix(String[] strs) {
               if(strs.length==0)  return new String("");
        int n = strs.length;
        
        String pre = strs[0];
        
        for(int i=1;i<n;i++){
            while(!strs[i].startsWith(pre)){
                if(pre == "")
                    return "";
                else{
                    pre = pre.substring(0, pre.length() - 1); //remove the last character in the prefix and check again
                }
            }
        }
        return pre;
    }
}
