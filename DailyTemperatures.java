//https://leetcode.com/problems/daily-temperatures/
/*
Time: O(n) where n = temperatures.length
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        if (temperatures == null || temperatures.length == 0)
            return result;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // if current temp is greater than previously seen, pop that index and store the
            // index difference
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i); // push index
        }

        return result;
    }

}
