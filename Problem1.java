// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> st = new Stack<>();
        int n=temperatures.length;
        int [] result = new int[n];
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
            {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}