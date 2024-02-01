// Time Complexity: O(n)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> l1 = new ArrayList<>();
        for(int i = 1 ; i<=n;i++){
            if(i%3==0 && i%5==0){
                l1.add("FizzBuzz");
            }
            else if(i%3==0){
                l1.add("Fizz");
            }
            else if(i%5==0){
                l1.add("Buzz");
            }
            else
                l1.add(Integer.toString(i));
        }
        return l1;
    }
}
