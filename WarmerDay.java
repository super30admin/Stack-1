// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * The approach is to use a Stack because it is last in, first out data structure. 
 * This pattern is called monotonic increase/decrease in a stack in which we need to identify whether the below elements 
 * in the array/stack can we processed before processing other elements. 
 * 1 - Traverse the array and while traversing, we first add the element into the stack.
 * 2 - Every element is compared with the element present in the stack. 
 * 3 - If incoming element is greater, we pop the element from the stack else we keep adding to the stack
 * 4 - If any elements are remaining in the stack, we do not do amything for such elements.
 */

public class WarmerDay {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 || temperatures == null)
            return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
            {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}
