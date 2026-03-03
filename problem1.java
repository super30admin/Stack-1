
    /**
    Time Complexity : O(N)
    Explanation:
    Each index is pushed to the stack once and popped at most once.
    So total operations across the loop are linear.

    Space Complexity : O(N)
    Explanation:
    Stack can store up to N indices in the worst case (strictly decreasing temps).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about what to store in the stack.
    Fixed it by storing indices (not values) so we can compute days difference (i - prevIndex).
    Also had to remember to set remaining indices in stack to 0 because they have no warmer future day.
    */
    class Solution {


        public int[] dailyTemperatures(int[] temperatures) {
    
            Stack<Integer> st = new Stack<>();
            int n = temperatures.length;
    
            for (int i = 0; i < n; i++) {
    
                // Pop all previous colder days and fill their answer
                while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                    int idx = st.pop();
                    temperatures[idx] = i - idx;
                }
    
                // Push current day index
                st.push(i);
            }
    
            // Remaining indices have no warmer day
            while (!st.isEmpty()) {
                temperatures[st.pop()] = 0;
            }
    
            return temperatures;
        }
    }