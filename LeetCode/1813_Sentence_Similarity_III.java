// Time Complexity: O(m+n)
// Space Complexity: O(m+n)

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // s1 is the smaller string 
        String s1[];
        String s2[];
        if(sentence1.length() < sentence2.length()){
            s1 = sentence1.split(" ");
            s2 = sentence2.split(" ");
        }else{
            s2 = sentence1.split(" ");
            s1 = sentence2.split(" ");
        }
        int l1=0,l2=0 , r1=s1.length-1, r2=s2.length-1;
        
        while(l1<s1.length && l2<s2.length && s1[l1].equals(s2[l2]) ) {
            l1++;
            l2++; //finds the longest matching prefix
        }
        while(r1>=0 && r2>=0 && s1[r1].equals(s2[r2])){
            r1--;
            r2--;
        }
    return l1>r1;
    }
}
