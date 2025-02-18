// monotonically decreasing stack.
// the nums will only get resolved when there is a number greater than the number in the stack.
// Time complexity= O(4*n)
// Space complexity = O(n).

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();// monotonically decreasing stack.
        int i=0;
        int n = nums.length;

        while(i<n) {
            if(stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && nums[i]> nums[stack.peek()]){
                    int j = stack.pop(); // got the index.
                    res[j] = nums[i]; // assigned the greater number.
                }
                stack.push(i);
            }
            i++;
        }
        // prepped for second pass.
        // there will always be an element which is gonna be in the stack.
        // that is going to be the max element.
        i = i%n; // comes back to 0
        while(i< n && i!= stack.peek()) {
            while(!stack.isEmpty() && nums[i]> nums[stack.peek()]){
                    int j = stack.pop(); // got the index.
                    res[j] = nums[i]; // assigned the greater number.
            }
            i++;
        }
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        
        return res;
    }
}