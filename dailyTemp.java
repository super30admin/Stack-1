// Time Complexity : O(N) iterate through all array elements
// Space Complexity : O(N) stack, result array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        //initializations
        int n = T.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        //base check
        if(T == null || T.length == 0) return ans;
        
        
        
        //start iterating
        for(int i= 0; i<n; i++){
           
           while(!s.isEmpty() && T[i] > T[s.peek()]) s.pop();
            ans[i] = s.isEmpty() ? -1 : s.peek();
            ans[i] = i - ans[i];
            s.push(i);
        }
        
        return ans;
    }
}