// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a Stack to record elements while checking if they satisfy the condition, where the top of the stack is less than the current element. Keep popping from the stack till a resolution is found. Finally, add the current element to the stack.

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0) return result;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < T.length; i++){
            
            while(!st.isEmpty() && T[st.peek()] < T[i]){
                int indx = st.pop();
                result[indx] = i - indx;
            }
            
            st.push(i);
        }
        
        return result;
    }
}
