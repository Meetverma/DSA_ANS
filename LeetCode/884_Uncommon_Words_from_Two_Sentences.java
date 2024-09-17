// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();

        String arr[] = s1.split(" ");
        
        for(String word: arr){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }
            else{
                map.put(word,1);
            }
        }
        arr = s2.split(" ");

        for(String word: arr){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }
            else{
                map.put(word,1);
            }
        }
        ArrayList<String> lst = new ArrayList<>();
        for(HashMap.Entry<String,Integer> set: map.entrySet() ){
            int occurance = set.getValue();
            if(occurance == 1 ){
                lst.add(set.getKey());
            }
        }
    String ans[] = new String[lst.size()];
    ans = lst.toArray(new String[lst.size()]);
    return ans;
    }
}
