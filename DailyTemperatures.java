// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Add elements to stack if the value is less than the top
//Else resolve as many elements as we can from top


class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        if(T == null || T.length == 0) return result;
        Stack<Integer> st = new Stack();



        for(int i = 0; i < T.length; i++){
            int newElement = T[i];

            while(!st.isEmpty() && T[st.peek()] < newElement) {
                //resolve it
                int top = st.pop();
                result[top] = i - top;
            }
            st.push(i);


        }
        return result;
    }
}
