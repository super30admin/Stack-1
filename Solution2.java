//Time complexity: O(n), where n is the length of temperatures.
//Space complexity: O(n)

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        
        int[] output = new int[nums.length];
        Arrays.fill(output, -1); 
        
        //first pass
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                output[index] = nums[i]; 
            }
            stack.push(i); 
        }
        
        //second pass
        int i = 0;
        while(i < nums.length && !stack.isEmpty() && stack.peek() != i ) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop(); 
                output[index] = nums[i]; 
            }
            i++;
        }
        
        return output;
    }
}