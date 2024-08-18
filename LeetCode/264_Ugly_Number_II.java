class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        
        long num = 1;

        for (int i = 0; i < n; i++) {
            num = pq.poll();
            if (i == n - 1) {
                return (int) num;
            }
            if (!pq.contains(num * 2)) {
                pq.add(num * 2);
            }
            if (!pq.contains(num * 3)) {
                pq.add(num * 3);
            }
            if (!pq.contains(num * 5)) {
                pq.add(num * 5);
            }
        }

        return (int) num;
    }
}
