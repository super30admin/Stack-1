// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int [] result = new int[size];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currDay = 0; currDay < size; currDay++) {
            int currDayTemp = temperatures[currDay];
            
            // Pop until the current day's temperature (currDayTemp) is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currDayTemp) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }

            stack.push(currDay);
        }
        
        return result;
    }
}