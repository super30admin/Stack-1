/*
739. Daily Temperatures
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
Traverse the temperatures array from start using a decreasing monotonic stack, so that when a temperature which is warmer comes up calculate its distance from the temperatures in stack which are cooler and set the result array
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){ // Traverse through the temperatures array
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){ // if incoming temp is more than temp on top of stack
                int idx = st.pop();
                result[idx] = i - idx; // Calculate the distance b/w the warmer temp
            }
            st.push(i); // Add the temperatures to the stack
        }

        return result;
    }
}