//Time = O(n)
//Space = O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length]; // initialize output array with all 0's
        Stack<Integer> stack = new Stack<>(); // initialize stack to keep track of indices

        for (int i = 0; i < temperatures.length; i++) { // iterate through input array
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { // while stack is not empty and current temperature is greater than the temperature at the top of the stack
                int idx = stack.pop(); // remove the top index from the stack
                ans[idx] = i - idx; // set the corresponding index in output array to the difference in indices
            }
            stack.push(i); // add the current index to the stack
        }
        return ans; // return the output array
    }
}
