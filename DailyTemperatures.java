// Time complexity = O(n)
// Space complexity = O(n), where n is the temperatures.
// monotonically decreasing stack and go forward. 
//Last In first out because the lowest temperature needs to be compared with the stack temperature.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonically decreasing stack
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);// first element of the temperatures array.
        
        for(int i=1;i< temperatures.length;i++) {
            // check whether the element referenced by i is > than the stack peek.
            // if so, pop from the stack.
            while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]) {// 75 >74, remove 74
                int idx = stack.pop();
                res[idx] = i- idx ;
            }
            stack.push(i);
        }
        return res;
        
    }
}