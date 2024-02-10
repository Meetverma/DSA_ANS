// Time Complexity: O(n^2);



class Solution {
    public int check(char L,char R){
        if(L==R)
            return 1;
        return 0;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int ans=0,temp=0;
        char s_arr[]=s.toCharArray();
        int L,R;
        int X,Y;
        
        for(int i=0;i<n;i++){
            L=i;R=i;
            X=i;Y=i+1;
            while(L>=0 && R<n){
                temp=check(s_arr[L],s_arr[R]);
                if(ans+temp == ans)
                    break;
                L--;
                R++;
                ans+=temp;
                temp=0;
            }
            
            while(X>=0 && Y<n){
                temp=check(s_arr[X],s_arr[Y]);
                if(ans+temp == ans)
                    break;
                X--;
                Y++;
                ans+=temp;
                temp=0;                
            }
        }

        return ans;
    }
}
