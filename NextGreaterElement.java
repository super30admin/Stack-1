// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i= 2* nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i%nums.length]){
                st.pop();
            }
            res[i%nums.length] = st.isEmpty() ? -1 : nums[st.peek()];
            st.push(i % nums.length);
        }
        return res;
    }
}
