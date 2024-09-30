// Time Complexity: O(K)
// Space Complexity: O(N)

class CustomStack {
    private ArrayList<Integer> stk;
    private int n;

    public CustomStack(int maxSize) {
        this.n = maxSize;
        stk = new ArrayList<>(maxSize);
    }

    public void push(int x) {
        if (stk.size() == n) {
            return;
        } else {
            stk.add(x);
        }
    }

    public int pop() {
        if (stk.size() >= 1) {
            return stk.remove(stk.size()-1);
        }
        return -1;
    }

    public void increment(int k, int val) {
        if (stk.size() < k) {
            for (int i = 0; i < stk.size(); i++) {
                stk.set(i, stk.get(i) + val);
            }
        } else {
            for (int i = 0; i < k; i++) {
                stk.set(i, stk.get(i) + val);
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
