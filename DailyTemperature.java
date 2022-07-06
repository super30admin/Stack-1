// Time Complexity : O(N+N) // ex: 7,6,5,4,3,2,1,9
// Space Complexity : O(N) //stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class DailyTemperature {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] op = new int[temperatures.length];
            Stack<Integer> st = new Stack<>();

            for(int i=0; i< temperatures.length; i++) {
                while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                     int curr = st.pop();
                    op[curr] = i - curr;
                }
                st.push(i);

            }

            return op;
        }
    }
}
