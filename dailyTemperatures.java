// Time complexity = O(n)
// Space complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a stack here to store the indexes of the temperatures that are lesser than the next higher temperature, once you find a higher temperature we can then be sure that the temperatures between the two are also less than the first temperature. Hence we update the result array of all these temperatures.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures == null || temperatures.length == 0) return result;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for (int i=1; i< temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int sElement = s.pop();
                result[sElement] = i - sElement;
            }
            s.push(i);
        }

        return result;
    }
}