class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                if(strs.length==0)
            return new ArrayList<>(Arrays.asList(Arrays.asList("")));
        HashMap<String,List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            char str_arr[]=strs[i].toCharArray();
            Arrays.sort(str_arr);
            String temp = String.valueOf(str_arr);
            
            if(map.containsKey(temp)){
                List<String> temp_list = map.get(temp);
                temp_list.add(strs[i]);
                map.put(temp,temp_list);
            }
            else{
                List<String> temp_list = new ArrayList<>();
                temp_list.add(strs[i]);
                map.put(temp,temp_list);
            }
        }
        List<List<String>> listoflist = new ArrayList<>(map.values());
        return listoflist;
    }
}
