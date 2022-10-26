// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];

        //Monotonic Decreasing Stack 4,3,2,1
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIndex = st.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            st.push(i);
        }
        return result;
    }
}