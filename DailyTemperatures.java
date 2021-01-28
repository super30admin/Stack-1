// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        if(T == null || T.length == 0) {
            return new int[] {};
        }
        
        int n = T.length;
        Stack<Integer> s = new Stack<>();
        
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && T[i] > T[s.peek()]) {
                int index = s.pop();
                result[index] = i - index;
            }
            s.push(i);
        }
        return result;
    }
}