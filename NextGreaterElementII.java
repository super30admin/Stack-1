package Dec21;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        
        // time complexity: O(2n) + O(n) = O(3n) ~= O(n)
        // space complexity: O(n)
        /*
        Approach:
        Using stack.
        Store unresolved index of current input array element in the stack.
        Move the pointer to next element in the array and compare if element at pointer index > element at stack peek index
        If yes, i.e. element at pointer index > element at stack peek index - then index inside stack is resolved now. a) We have got a next greater element for the index inside stack, so pop this from the stack. b) Add in result array: arr[ptr]
        For circular scenario, we need to handle the case when any array element(/s) dont have any greater element even when we approach towards the last element in the array.  
        
        Note: push elements only in first traversal on the array and not second.
        */
        
        // edge
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for (int i = 0;  i < 2*n; i++) {
            while (!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i%n];
            }
            // push elements only in first traversal on the array and not second.
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}