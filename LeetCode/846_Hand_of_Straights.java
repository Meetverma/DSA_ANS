class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length%groupSize!=0)
            return false;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<hand.length;i++){
            if(map.containsKey(hand[i])){
                map.put(hand[i],map.get(hand[i])+1);
            }
            else
                map.put(hand[i],1);
            // System.out.println(map.get(hand[i]));
        } 

        // System.out.println(map);

        PriorityQueue<Integer> minheap = new PriorityQueue<>(map.keySet());

        while(!minheap.isEmpty()){
            int first = minheap.peek();

            for(int i = first ;i<first+groupSize;i=i+1){
                if(!map.containsKey(i)){
                    return false;
                }
                else{
                    map.put(i,map.get(i)-1);
                    if(map.get(i)==0 && minheap.peek()!=i){  
                            return false;
                            }
                    if(map.get(i)==0)
                        minheap.poll();
                }
            }

        }
        return true;
    }
}
