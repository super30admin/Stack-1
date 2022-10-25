// Time complexity: O(n)
// Space complexity: O(n)

// Approach: Monotonous Decreasing Stack Pattern. Basically we will iterate through the array and everytime we find a decreasing element (by comparing it to top of stack), we can add it to the stack (we add the index as we need to calculate number of days), but if we find an increasing element (greater than top of stack), we pop until we find a greater element in the stack. When popping we need to store the index of the current element - popped element as our answer.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = currDay-index;
            }
            stack.push(currDay);
        }
        return result;
    }
}