//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 || temperatures == null) {
            return new int[0];
        }
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            //if the incoming temperature is greater than the top of the stack, we can resolve top
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;
    }
}