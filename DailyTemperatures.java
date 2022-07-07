// Time Complexity : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No



class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            // monotonic stack is maintained
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int curr = s.pop();
                res[curr] = i-curr;
            }
            s.push(i);
        }
        return res;
    }
}