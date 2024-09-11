// Dikjastra's approach 

class Pair{
    double curVal;
    double steps;
    
    Pair(double curVal ,double steps){
        this.curVal = curVal;
        this.steps = steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        double dist[] = new double[100000];
        
        Arrays.fill(dist,Double.MAX_VALUE);
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)-> Double.compare(a.steps,b.steps));

        dist[start] = 0;
        
        queue.add(new Pair((double)start,0));
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            double curVal = temp.curVal;
            double curSteps = temp.steps;
            
            if(curVal == (int) end){
                return (int) curSteps;
            }
            
            for(int i=0;i<arr.length;i++){
                double nextNode = (curVal * arr[i]) % 100000;
                double nextSteps = curSteps+1;
                if( nextSteps < dist[(int)nextNode]){
                    dist[(int)nextNode] = nextSteps;
                    queue.add(new Pair(nextNode, nextSteps));
                }
            }
        }
    return -1;
        
    }
}

