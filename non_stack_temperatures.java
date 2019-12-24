//Time Complexity: O(n^2)
//Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] dp = new int[T.length];
        int j=0;
        for(int i=0;i<T.length;i++){
            j=i;
            if(i==T.length-1) dp[i]=0;
            if(j<T.length-1){
               j=i+1;
               if(T[j]-T[i]>0) dp[i]=j-i;
               else{
                    while(T[j]-T[i]<=0&&j<T.length-1) j++;
                    if(T[j]-T[i]>0) dp[i]=j-i; 
                }
            }
        }
        return dp;
    }
}
