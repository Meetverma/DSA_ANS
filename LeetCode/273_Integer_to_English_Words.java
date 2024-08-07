// Time Complexity: O(N)
// Space Comoplexity: O(1)

class Solution {
    private static final HashMap<Integer, String> ones = new HashMap<>();
    private static final HashMap<Integer, String> tens = new HashMap<>();

    static {
        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");
        ones.put(10, "Ten");
        ones.put(11, "Eleven");
        ones.put(12, "Twelve");
        ones.put(13, "Thirteen");
        ones.put(14, "Fourteen");
        ones.put(15, "Fifteen");
        ones.put(16, "Sixteen");
        ones.put(17, "Seventeen");
        ones.put(18, "Eighteen");
        ones.put(19, "Nineteen");
        tens.put(20, "Twenty");
        tens.put(30, "Thirty");
        tens.put(40, "Forty");
        tens.put(50, "Fifty");
        tens.put(60, "Sixty");
        tens.put(70, "Seventy");
        tens.put(80, "Eighty");
        tens.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] names = { "", " Thousand", " Million", " Billion" };
        int i = 0;
        String ans = "";

        while (num != 0) {
            int threeDigit = num % 1000;
            String s = makeString(threeDigit);
            if (!s.isEmpty()) {
                ans = s + names[i] + (ans.isEmpty() ? "" : " ") + ans;
            }
            i++;
            num = num / 1000;
        }
        return ans;
    }

    private String makeString(int num) {
        StringBuilder s = new StringBuilder();
        int h = num / 100;
        if (h != 0) {
            s.append(ones.get(h)).append(" Hundred");
        }
        int t_o = num % 100;
        if (t_o != 0) {
            if (t_o <= 19) {
                if (s.length() > 0) {
                    s.append(" ");
                }
                s.append(ones.get(t_o));
            } else {
                int msb = t_o / 10 * 10;
                int lsb = t_o % 10;
                if (s.length() > 0) {
                    s.append(" ");
                }
                s.append(tens.get(msb));
                if (lsb != 0) {
                    s.append(" ").append(ones.get(lsb));
                }
            }
        }
        return s.toString();
    }

}
