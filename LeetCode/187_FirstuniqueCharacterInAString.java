/*
keep the track of occurances of a character in the string 
keep pushing the char with 1 occurance to the queue 
for each loop check the head's occurances 
  remove it if not equal to 1

*/

class Solution {
    public int firstUniqChar(String s) {
               HashMap<String,Integer> map = new HashMap<>();
        Queue<String> que= new LinkedList<>();


        for(int i=0;i<s.length();i++){
            map.put(String.valueOf(s.charAt(i)), map.containsKey(String.valueOf(s.charAt(i)))==false? 1 : map.get(String.valueOf(s.charAt(i)))+1 );
            if(map.get(String.valueOf(s.charAt(i)))==1)
                que.add(String.valueOf(s.charAt(i)));
            
            if(!que.isEmpty())
                while(map.get(que.peek())>1 ){
                    que.remove();
                    if(que.isEmpty())
                        break;
                }
        }
        if(que.isEmpty())
            return -1;
        return s.indexOf(que.peek());
    }
}
