// Time Complexity :2 o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no 


// Your code here along with comments explaining your approach: using monotonic stack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
 
        for(int i = 0; i< temperatures.length;i++ )
        {
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()])
            {
                int poppped = st.pop();
                result[poppped] = i - poppped;
            }
            st.push(i);
            
       }
        return result;   
    }
}