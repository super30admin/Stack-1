import java.util.Stack;

//Time complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[] {};

        int n = temperatures.length;
        if (n == 1) {
            return new int[] { 0 };
        }
        Stack<Integer> s = new Stack<>(); // holds the indices
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int idx = s.pop();
                result[idx] = i - idx;
            }
            s.push(i); // to process the curr element or for the entering the first index into the
                       // stack.
        }

        return result;

    }
}