// Time Complexity: O(logN);
// Space Complexity: O(N);

class Pair {
    String str;
    int val;

    Pair() {
    }

    Pair(int val, String str) {
        this.str = str;
        this.val = val;
    }
}

class AllOne {
    HashMap<String, Integer> map;
    TreeSet<Pair> set;

    public AllOne() {
        map = new HashMap<>();
        set = new TreeSet<>((a, b) -> {
            if (a.val == b.val) {
                return a.str.compareTo(b.str);
            }
            return Integer.compare(a.val, b.val);
        });
    }

    public void inc(String key) {
        int got = map.getOrDefault(key, 0);
        map.put(key, got + 1);
        set.remove(new Pair(got, key));
        set.add(new Pair(got + 1, key));
    }

    public void dec(String key) {
        int got = map.get(key);
        set.remove(new Pair(got, key));
        map.put(key, got - 1);
        if (got - 1 == 0) {
            map.remove(key);
            return;
        }
        set.add(new Pair(got - 1, key));
    }

    public String getMaxKey() {
        if (set.isEmpty()) {
            return "";
        }
        return set.last().str;
    }

    public String getMinKey() {
        if (set.isEmpty()) {
            return "";
        }
        return set.first().str;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
