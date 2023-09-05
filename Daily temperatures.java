// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Iterate through the array and add the elements in the stack.Create a result array of length same as the temperatures array. 
// Check if the element which was add previously is smaller than the current index. If it is add the difference between the current 
// index and the previous index in the result array at index=previous index.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length==0) return new int[0];
        int[] result=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<temperatures.length;i++)
        {
            //until the stack gets empty or we find an element greater than the previous element
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i])
            {
                int popped=st.pop();    //this will store the index of the previous element
                result[popped]=i-popped;
            }
            //we will push the element which needs to be processed

            st.push(i);
        }
        return result;
    }
}