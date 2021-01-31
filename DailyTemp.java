//Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
//If there is no future day for which this is possible, put 0 instead.
// TC O(N) SC O(N) - Stack space. 
//Keep pushing index of elements and if the current temp is greater than the temp at peek of stack, pop and add the difference in index to result
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        int[] result = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!s.isEmpty() && T[i] > T[s.peek()]) {
                int index = s.pop();
                result[index] = i-index;
            }
            s.push(i);
        }
        return result;
    }
}
