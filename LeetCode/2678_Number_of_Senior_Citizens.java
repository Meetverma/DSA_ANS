// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int countSeniors(String[] details) {
        int age_idx1 = 11 , age_idx2 = 12;
        int count = 0;
        for(int i=0;i<details.length;i++){
            char chars[] = details[i].toCharArray();
            String age =new String(new char[]{chars[age_idx1] , chars[age_idx2]} ); 
            if( Integer.parseInt(age) > 60 ){
                count++;
            }
        }

    return count;

    }
}
