// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DailyTemperature {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int[] result = new int[n];

            for(int i = 1; i < n; i++){
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int popped = stack.pop();
                    result[popped] = i - popped;
                }
                stack.push(i);
            }
            return result;
        }
    }
}
