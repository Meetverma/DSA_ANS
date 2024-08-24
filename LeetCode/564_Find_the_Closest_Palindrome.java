// Thanks to Alpha-Code for the solution

class Solution {
    private long helper(long half, boolean isEven) {
        String halfStr = Long.toString(half);
        String palin;
        if (isEven) {
            palin = halfStr + new StringBuilder(halfStr).reverse().toString();
        } else {
            palin = halfStr + new StringBuilder(halfStr.substring(0, halfStr.length() - 1)).reverse().toString();
        }
        return Long.parseLong(palin);
    }

    public String nearestPalindromic(String n) {
        int len = n.length();

        if (len == 1) {
            return Integer.toString(Integer.parseInt(n) - 1);
        }

        long original = Long.parseLong(n);
        long lessDig = (long) Math.pow(10, len - 1) - 1;
        long moreDig = (long) Math.pow(10, len) + 1;

        long halfVal = Long.parseLong(n.substring(0, (len + 1) / 2));

        long same = helper(halfVal, len % 2 == 0);
        long smaller = helper(halfVal - 1, len % 2 == 0);
        long bigger = helper(halfVal + 1, len % 2 == 0);

        long[] candidates = {lessDig, moreDig, same, smaller, bigger};
        Arrays.sort(candidates);

        long closest = Long.MAX_VALUE;
        for (long c : candidates) {
            if (c == original) continue;
            if (Math.abs(c - original) < Math.abs(closest - original) ||
                (Math.abs(c - original) == Math.abs(closest - original) && c < closest)) {
                closest = c;
            }
        }
        return Long.toString(closest);
    }
}
