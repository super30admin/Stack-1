// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a stack and when ever we see  next element less than equal to top of stack
// We push it in the stack, otherwise we will pop from stack and store the difference
// of indices in the corresponding result array.
// We will complete the iteration of the array and return the result
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = 0; i < temperatures.length; i++){
            int num = temperatures[i];
            while(!st.isEmpty() && num > temperatures[st.peek()]){
                int curIndex = st.pop();
                res[curIndex] = i - curIndex;
            }
            st.push(i);
        }
        return res;
    }
}