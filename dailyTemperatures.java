/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //base case
        if (temperatures.length == 0 || temperatures == null) {
            return new int[] {};
        }

        //logic
        int n = temperatures.length;
        Stack<Integer> s = new Stack<Integer>();
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int popped = s.pop();
                result[popped] = i - popped;
            }
            s.push(i);
        }

        return result;
    }
}