// Solved using binary Search Algorithm 
// Time Complexity: O(Log(Max)∗N)


class Solution {
    int getB(int arr[],int mid , int k){
        int noB=0;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                cnt++;
            }
            else{
                cnt=0;
            }
            if(cnt==k){
                noB++;
                cnt=0;
            }
        }
        return noB;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max = bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            if(max<=bloomDay[i])
                max = bloomDay[i];
        }//max fn 

        int low=0;
        int ans =-1;
        while(low<=max){
            int mid = (low+max)/2;
            if(getB(bloomDay,mid,k) < m){
                low = mid +1;
            }
            if(getB(bloomDay,mid,k) >= m){
                ans = mid;
                max= mid-1;
            }
        }
        return ans;
    }
}
