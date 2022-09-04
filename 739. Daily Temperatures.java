// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[] {};
        }
        if(temperatures.length == 1){
            return new int[] {0};
        }
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int idx = s.pop();
                result[idx] = i - idx;
            }
            s.push(i);
        }
        return result;
    }
}