/* Time Complexity : O(2n) ~ O(n)
 *   n - length of array - temperatures  */
/* Space Complexity : O(n) 
 * stack size */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Monotonic decreasing stack

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res;
    }
}