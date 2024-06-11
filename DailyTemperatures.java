// Time Complexity : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using monotonic increasing stack -> adding index of temperatures to stack
// resolving the elements of stack if the current temp is greater
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[n];

        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int pop = st.pop();
                answer[pop]= i-pop;
            }

            st.push(i);
        }

        return answer;
    }
}