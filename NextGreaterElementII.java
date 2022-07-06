// Time Complexity : O(3N) //
// Space Complexity : O(N) //stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class NextGreaterElementII {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] op = new int[n];
            Arrays.fill(op, -1);
            Stack<Integer> st = new Stack<>();


            for(int i=0; i< 2*nums.length; i++) { //why 2*N? because no mater what, we will find output at the most iterating twice
                while(!st.isEmpty() && nums[st.peek()] < nums[i%n]) {
                    int curr = st.pop();
                    op[curr] = nums[i%n];
                }
                if(i < n)
                    st.push(i);

                //optimization:- if in second round you come acrosss the same elemen in the top of the stack, you don't need to g further
                if(i>=n && st.peek() == i%n)
                    break;
            }

            return op;

        }
    }
}
