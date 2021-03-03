// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
	/* Initially, the result array will be marked as -1 across the length of the array.
	 * Here, the Elements are retrieved from the array and checked where it is greater than the index of the element at the top of the stack.
	 * If true, then the index stored in the stack will be popped and the greater element will assigned in the result index array.
	 * this traversal will be performed 2 times in cycle until the element reaches the element greater than itself. if not then -1 will be 
	 * retained for that index in the result array.
	 */

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_2 {
	public int[] nextGreaterElements(int[] nums) {
        int [] result = new int [nums.length];
        Stack<Integer> st = new Stack<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.fill(result, -1);
        int n = nums.length;
        for(int i = 0; i < 2 * n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int index = st.pop();
                result[index] = nums[i%n];
            }
            if(i < nums.length){
                st.push(i);
            }
        }
        return result;
    }
}
