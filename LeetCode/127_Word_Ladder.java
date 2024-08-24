class Pair {
    String key;
    Integer value;
    
    Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>(); 
        queue.add(new Pair(beginWord,1));

        char a = 'a';
        int step=0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String cur = p.key ;
            Integer steps = p.value;
            if(cur.equals(endWord)){
                return steps;
            }

            for(int i = 0;i<beginWord.length();i++){
                StringBuilder x = new StringBuilder(cur);
                for(int j=0;j<26;j++){
                    x.setCharAt(i,(char)(a+j));
                    if( set.contains(x.toString()) && x.toString()!= beginWord){
                        queue.add(new Pair(x.toString(),steps+1));
                        set.remove(x.toString());
                    }
                }
            }
        }
        return step;

    }
}
