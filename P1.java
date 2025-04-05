/* 
Time Complexity:O(N)

Space Complexity:O(N)

Approach- I'll keep adding the indices to the stack until I encounter an index when element at that index is less than the current index. 
In this case, I'll pop and update the values of all the indices before that until the stack is empty.

*/


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i ++) {
            int curr = temperatures[i];
            while (!st.isEmpty() && curr > temperatures[st.peek()]) {
                int poppedIdx = st.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            st.push(i);
        }
        return result;
    }
}
