class Solution {
    public Boolean isPalin(String word){
        int n = word.length();
        if(n==1)
            return true;

        int i=0,j=n-1;
        while(i<=j){
            if(word.charAt(i)!=word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
    public String firstPalindrome(String[] words) {

        for(int i=0;i<words.length;i++){
            if(isPalin(words[i])){
                return words[i];
            }
        }
        return "";
    }
}
