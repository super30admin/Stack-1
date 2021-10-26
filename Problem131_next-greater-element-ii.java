// Time Complexity: O(3n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0)
            return result;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i = 0; i < 2 * nums.length; i++) {
            while(!st.isEmpty() && nums[i%nums.length] > nums[st.peek()]) {
                int topIdx = st.pop(); 
                result[topIdx] = nums[i % nums.length];
            }
            if(i < nums.length)
                st.push(i);
        }
        return result;
    }
}