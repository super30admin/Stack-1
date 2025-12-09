// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
Approach
We will be using a monotonic decreaseing stack, the idea it to put temp into a stack
till be find a temp that is higher then peek, then we start popping the elements and compaing them
and store the differnce of the popped index to cur in a different array

return that array
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.add(i);
        }
        return result;
    }
}