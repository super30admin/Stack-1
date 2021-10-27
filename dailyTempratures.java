// Time Complexity: O(n)
// Space Complexity: O(n)
// until we get a warmer day we keep pushing the indexes to stack
// once a warmer day is encountered, we keep popping from stack to assign the difference
// to the result index that when finally a warmer day came.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0; i< temperatures.length; i++) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    int top = stack.pop();
                    result[top] = i-top;
                }
            }
            stack.push(i);
        }
        return result;
    }
}