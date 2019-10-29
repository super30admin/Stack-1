// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// brute force solution
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++){
            for(int j = i+1;j<T.length;j++){
                if(T[j]>T[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }
}
