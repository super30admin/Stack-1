// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    // Brute Force
    // Time Complexity : O(n^2)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int[] nextGreaterElementsBF(int[] nums) {
        int[] doubleArray = new int[nums.length * 2];
        int[] output = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            doubleArray[i] = nums[i];
            doubleArray[nums.length + i] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < doubleArray.length; j++){
                if(doubleArray[j] > nums[i]){
                    output[i] = doubleArray[j];
                    break;
                } else {
                    output[i] = -1;
                }
            }
        }

        return output;
    }

    // Optimized
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for(int x = 0; x < 2*nums.length; x++){
            int i = x % nums.length;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int popped = stack.pop();
                result[popped] = nums[i];
            }
            if(result[i] == -1){
                stack.push(i);
            }
        }
        return result;
    }
}
