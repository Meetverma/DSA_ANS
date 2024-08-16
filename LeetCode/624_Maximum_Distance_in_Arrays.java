// Time Complexity: O(N) N: Number of arrays
// Space Complexity: O(1)

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxe = Integer.MIN_VALUE;
        int mine = Integer.MAX_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;

        int lastMaxIdx = -1, lastMinIdx = -1;

        List<Integer> temp;
        for (int i = 0; i < arrays.size(); i++) {
            temp = arrays.get(i);
            int cur_min = temp.get(0);
            int cur_max = temp.get(temp.size() - 1);

            if (cur_max > maxe) {
                secondMax = maxe;
                maxe = cur_max;
                lastMaxIdx = i;
            } else if (cur_max > secondMax) {
                secondMax = cur_max;
            }

            if (cur_min < mine) {
                secondMin = mine;
                mine = cur_min;
                lastMinIdx = i;
            } else if (cur_min < secondMin) {
                secondMin = cur_min;
            }
        }

        if (lastMaxIdx != lastMinIdx) {
            return Math.abs(maxe - mine);
        } else {

            return Math.max(Math.abs(maxe - secondMin), Math.abs(secondMax - mine));
        }
    }
}
