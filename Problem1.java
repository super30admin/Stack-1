// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //method 1 monotonic increasing stack
    //TC:O(2n) SC:O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        //null
        if(temperatures==null || temperatures.length ==0) return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for( int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }

} 