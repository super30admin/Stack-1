// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        if(temperatures == null || temperatures.length == 0)
            return new int[0];

        int[] result = new int[temperatures.length];

        //monotonic increasing stack
        Stack<Integer> stack = new Stack();

        for(int i=0; i<temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
