import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
public class DailyTemperatures {

    class Solution {
        public int[] dailyTemperatures(int[] T) {

            int[] res = new int[T.length];//create array to store ans
            Stack<Integer> st = new Stack<>();//create stack to store array elemets

            //itearate over array and check if the stack is not empty and if current temperature is greater than or
            //equal to the top temperature in the stack, if it is then pop the value from the stack.
            //add 0 to res array if stack is empty else subtract top value in stack from current index and add to res array
            //push index on to stack
            for (int i = T.length; i >=0 ; --i) {
                while(!st.isEmpty() && T[i] >= st.peek()) st.pop();
                res[i] = st.isEmpty() ? 0 : st.peek() - i;
                st.push(i);
            }
            return res;// return result
        }
    }
}
