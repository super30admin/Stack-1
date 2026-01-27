// Time Complexity : O(2n) => O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We use a Stack to maintain the temperatures present in the array
// 2: If our current element can resolve (is greater than) the peek element in the stack, we pop it out and add the difference in indexes to the array
// 3: We compare and pop each element from the stack until we have processed each daily temperature
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                // pop
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;

    }
}