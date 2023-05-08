/**
Time Complexity - O(n)
Space Complexity - O(n)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return new int[0];
        
        int n = temperatures.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int poppedIndex = stack.pop();
                output[poppedIndex] = i - poppedIndex;
            }
            stack.push(i);
        }
        return output;
    }
}
