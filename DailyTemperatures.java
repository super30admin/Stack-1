class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            stack.push(i);
        }

        return result;
        
    }
}