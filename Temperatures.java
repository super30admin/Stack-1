/*
 * #739. Daily Temperatures
 * 
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

 */


/*
 * Brute Force:
 *	Time Complexity: O (n^2) -> For each 'i', traversing through rest 'j' elements until we get a warmer temperature
 *
 *	Space Complexity : O (1) -> No extra space used
 *
 *Stack Approach:
 *	Time Complexity: O (N + N) = O (2N)-> Traversing through 'N' elements of an input array, for a particular element(day), we might have to traverse 'N' times to get a warmer temperature
 *
 *	Space Complexity : O (N) -> stack is used to store the indices of 'N' elements in an input array
 *
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.stack1;

import java.util.Stack;

public class Temperatures {
	public int[] dailyTemperatures(int[] T) {
        
        // Base condition
        if(T == null || T.length == 0){
            return new int[0];
        }
        
        /**************** Brute Force Approach *******************/
        /*
        *   Time Complexity: O (n^2) -> For each 'i', traversing through rest 'j' elements until we get a warmer temperature
        *   Space Complexity : O (1) -> No extra space used
        */
        
        // Create a resultant array, all elements initialized with 0
        int[] result = new int[T.length];
        
        // Using two pointers, traverse the array, for each i, go through all other j elements and see if we can get warmer temperature
        for(int i = 0; i < T.length - 1; i++){
            int j = i+1;
            
            // Increment 'j' pointer until we get a warmer temperature
            while(j < T.length && T[j] <= T[i]){
                j++;
            }
            
            // If we get a warmer temperature and 'j' pointer is within bounds, get the difference between two pointers indices and add to resultant array
            if(j < T.length){
                result[i] = j - i;
            }
            
        }
        
        //return result;
        
        /**************** Stack Approach *******************/
        /*
        *   Time Complexity: O (N + N) = O (2N)-> Traversing through 'N' elements of an input array, for a particular element(day), we might have to traverse 'N' times to get a warmer temperature
        *   Space Complexity : O (N) -> stack is used to store the indices of 'N' elements in an input array
        */
        
        
        // Create a stack that will store the indices
        Stack<Integer> stack = new Stack<Integer>();
        
        // Traverse the elements of an array
        for(int i = 0; i < T.length; i++){
            
            // Do until we have unprocessed elements in stack and we have a warmer temperature for the day(top of stack, unprocessed)
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                
                int pop = stack.pop(); // Get the index of unprocessed day
                // Number of days needed to wait for a warmer temperature
                result[pop] = i - pop; // difference between current(warmer temperature) index and popped index
                
            }
            
            // Initially when stack is empty or when it becomes empty, push the current element index in stack 
            // Stack consist of all the unprocessed elements, the day on which we have to tell how many days to wait for warmer temperature
            stack.push(i); 
            
        }
        
        return result;
   
        
    }

}
