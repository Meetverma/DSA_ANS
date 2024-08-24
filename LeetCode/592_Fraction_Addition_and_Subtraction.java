class Solution {

    public ArrayList<Integer> parseFractionToInt(String s) {
        String fractions[] = s.split("(?=[+-])"); // splits the string into '1/2' or '-1/2' for example

        ArrayList<Integer> intArr = new ArrayList<>();

        for (String x : fractions) {
            String parts[] = x.split("/");
            intArr.add(Integer.parseInt(parts[0])); // numerator
            intArr.add(Integer.parseInt(parts[1])); // denominator
        }
        return intArr;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public String fractionAddition(String expression) {
        ArrayList<Integer> intArr = parseFractionToInt(expression); // example: [1, 2, -1, 3]
        
        int resultNumerator = 0;
        int resultDenominator = 1;

        for (int i = 0; i < intArr.size(); i += 2) {
            int numerator = intArr.get(i);
            int denominator = intArr.get(i + 1);
            // lcm
            int lcm = lcm(resultDenominator, denominator);

            resultNumerator = resultNumerator * (lcm / resultDenominator) + numerator * (lcm / denominator);
            resultDenominator = lcm;
        }

        int gcd = gcd(Math.abs(resultNumerator), resultDenominator);
        resultNumerator /= gcd;
        resultDenominator /= gcd;

        return resultNumerator + "/" + resultDenominator;
    }

}
