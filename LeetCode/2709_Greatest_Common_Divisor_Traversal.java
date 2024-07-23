//A huge Thanks to NeetCode for this solution;

class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, Integer> factorIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = 2;
            while (f * f <= num) {
                if (num % f == 0) {
                    if (factorIndex.containsKey(f)) {
                        uf.union(i, factorIndex.get(f));
                    } else {
                        factorIndex.put(f, i);
                    }
                    while (num % f == 0) {
                        num /= f;
                    }
                }
                f++;
            }
            if (num > 1) {
                if (factorIndex.containsKey(num)) {
                    uf.union(i, factorIndex.get(num));
                } else {
                    factorIndex.put(num, i);
                }
            }
        }

        return uf.getCount() == 1;
    }
}
