class Solution {
    public int furthestBuilding(int[] h, int bricks, int ladders) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        int curpos = 0;

        for (int i = 0; i < h.length - 1; i++) {
            int diff = h[i + 1] - h[i];
            if (diff <= 0)
                curpos = i+1;
            else {
                // use the brick;
                bricks -= diff;
                max_heap.add(diff);

                if (bricks < 0) {
                    if (ladders > 0) {
                        ladders--;
                        bricks += max_heap.poll();
                        curpos=i+1;
                    } 
                    else{
                        curpos=i;
                        break;
                    }
                }
                else
                    curpos=i+1;
            }
        }
        return curpos;

    }
}
