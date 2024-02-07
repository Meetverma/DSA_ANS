// a longer approach 
// can also be done using a pritority queue

class Solution {
    public String frequencySort(String s) {
        if(s.length() == 1)
            return s;
        HashMap<String,Integer> map = new HashMap<>();
        int n = s.length();
        String ans="";
        for(int i=0;i<n;i++){
            if(map.containsKey( String.valueOf(s.charAt(i))))
                map.put( String.valueOf(s.charAt(i)) ,map.get(String.valueOf(s.charAt(i))) +1 );
            else
                map.put( String.valueOf(s.charAt(i)) ,1 );
        }
        
        // TreeMap<String,Integer> tree = new TreeMap<>(map); this will sort on the basis of keys we need to sort on the basis of values
        List<Map.Entry<String,Integer>> lst = new ArrayList<>(map.entrySet());
        Collections.sort(lst, (a, b) -> b.getValue().compareTo(a.getValue())); 

        // lst.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String,Integer> entry : lst) {
            ans +=entry.getKey().repeat(entry.getValue());
    }
    return ans;
    }
}
