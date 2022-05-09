//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] output_arr = new int[n];
        Arrays.fill(output_arr,-1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2*n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                output_arr[stack.pop()] = nums[i%n];
            }
            if(i<n) stack.push(i);
        }
        return output_arr;
    }
}
