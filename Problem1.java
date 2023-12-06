// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < temperatures.length; i++){
            int curr = temperatures[i];
            while(!stk.isEmpty() && curr > temperatures[stk.peek()]){
                int popped = stk.pop();
                res[popped] = i - popped;
            }
            stk.push(i);
        }
        return res;
    }
}