// monotonically decreasing stack , why ? because temperatures get resolved when the temperature is greater than the stack peek.
// Time complexity = O(2n) which is O(n)
// Space complexity = O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int n =temperatures.length;
        while(i< n ) {
            if(stack.isEmpty() || temperatures[i]<= temperatures[stack.peek()]) {
                stack.push(i);  // monotonically decreasing stack.
                // 75->74-> 73
            } else {
                while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]) {
                    int j = stack.pop();// get the integer.
                    res[j] = i-j;
                }
                stack.push(i);
            }
            i++;
        }
        return res;
    }
}