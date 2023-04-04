//O(2n)
//O(n) - st
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a stack and push each index in to the stack. Before pushing check if the
 * current index is greater than stack's peek element. If so, get the difference
 * of the peek and current index and update in the peek element's index and pop
 * it. Finally return the answer.
 *
 */
//Monotonic stack 
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //null 
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int [] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}
