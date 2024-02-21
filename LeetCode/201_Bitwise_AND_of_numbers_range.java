class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int i=0;
        if(left == right)
            return left&right;
        while(left!=right){
            left = left>>1;
            right = right>>1;
            i++;
        }
        return (left&right)<<i;
    }
}
