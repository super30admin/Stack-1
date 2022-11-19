// Time Complexity:  O(N)
// Space Complexity : O(N), N-> worst case is length of input array
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[] {};

        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i ++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                result[index] =i - index;
            }
            s.push(i);
        }

        return result;
    }
}
