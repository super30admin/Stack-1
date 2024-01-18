// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using Stack
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int prev = st.pop();
                result[prev] = i-prev;
            }
            st.push(i);
        }

        return result;
    }
}

/**
 * Constant Space Solution, (Maybe DP)
 */
// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];
        int hottest = 0;
        for(int i=n-1; i>=0; i--) {
            if(temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }

            int days = 1;
            while(temperatures[i+days] <= temperatures[i])
                days += result[i+days];
            result[i] = days;
        }

        return result;
    }
}