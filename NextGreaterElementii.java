/*
 * #503. Next Greater Element II
 * 
 * Given a circular array (the next element of the last element is the first element of the array), 
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
 * which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.


Note: The length of given array won't exceed 10000.

 */


/*
 * Time Complexity: O (2N + N) -> 2N - two iterations/for loop for each unprocessed element in input array since this is a circular array, N - for a particular element, we might have to traverse 'N' times to get a next greater element
 * 
 * Space Complexity: O (N) -> Created stack to store 'N' unprocessed elements in input array
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.stack1;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementii {
	public int[] nextGreaterElements(int[] nums) {
        
        // #1. Base condition
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        // #2. Create a resultant array
        int[] result = new int[nums.length];
        
        // #3. Create a stack to store indices of elements in input array
        Stack<Integer> stack = new Stack<Integer>();
        
        // #4. Array elements are initialized to 0 when created, fill the array with -1 values
        Arrays.fill(result, -1);
        
        // #5. Traverse through the circular array
        /*
        *   Since, this is a circular array, for each element in given array, we will have 2 iterations/for loops
        *   e.g: nums = [1, 2, 1]
        *   In one for loop:
        *       For 1 at index 0, we will traverse the elements 2,1
        *       For 2 at index 1, we will traverse the element 1
        *       For 1 at index 2, we will traverse nothing 
        *   In second for loop
        *       For 1 at index 0, do nothing, already traversed the elements
        *       For 2 at index 1, traverse the 1 at 0th index
        *       For 1 at index 2, traverse elements 1,2
        */
        for(int i = 0; i < nums.length*2; i++){ // nums.length*2 -> two for loops
            // Execute this to prevent out of bounds exception
            // e.g: nums = [1,2,1] -> when i = 3, we will do 3 % 3 = 0, we will adjust 'i' to 0 to avoid above exception 
            int x = i % nums.length; 
            
            // Do this until stack is not empty and we have a found a next greater element for the element at an index in stack top
            while(!stack.isEmpty() && nums[x] > nums[stack.peek()]){
                int pop = stack.pop();
                result[pop] = nums[x]; // put the next greater value for an element at index at top of stack
            }
            
            // When stack is initially empty or when it becomes empty, if the elements are not already processed, push their index to stack top
            if(result[x] == -1){
                stack.push(x);
            }
            
        }
        
        return result;
        
        
    }

}
