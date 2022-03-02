package stacks1;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	//Time Complexity : O(n), where n is length of nums array
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<2 * n; i++) {
            if(!stack.isEmpty() && (stack.peek() == i % n))
                break;
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int popped = stack.pop();
                res[popped] = nums[i % n];
            }
            if(i < n)
                stack.push(i);
        }
        return res;
    }
}
