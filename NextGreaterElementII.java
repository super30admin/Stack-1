/*Approach:
1. Initialise the result array to -1
2. Use a stack. go through the array, if next number is greater, check if the stack is non-empty. 
3. If it is non-empty, go through all the elements in stack till this number is greater than the numbers in stack.
4. Add the number to the stack.
5. Process the stack till it is empty or till we have finished one more round of the array: example: [5,4,3,2,1], stack: [1,2,3,4,5]. For [9,5,6,4,3,8,10], stack: [10,9]
6. While the number in the array is greater than numbers in the stack, nums[i] = 5 > 1,2,3,4: Replace all of these with 5. When nums[i]=9, don't replace, when nums[i] = 10, replace 9 in the stack with it. 
7. We have to make 2 round of the array. in case of [1,1,1,1,1], the stack will never be empty. So we come out after the 2nd round.

Time complexity: O(2N), at max, we will go through the array twice. 
While removing elements from stack, line
*/
import java.util.*;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[nums.length];
        Arrays.fill(results, -1);
        for(int i = 0; i<=nums.length-1; i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]) //this is very important. Can't be handled in last processing of stack. Because for [9,5,6,4,3,8,10], stack will be [10,4,6,9]. 
                                                                  //if the bigger number is at the top, peak would always return the biggest number. To finish the processing in 2N, we have to do this. 
                results[stack.pop()] = nums[i];
            if(i<nums.length-1 && nums[i+1]>nums[i])
                results[i] = nums[i+1];
            else
                stack.push(i);
        }
        
        int i = 0;
        while(!stack.isEmpty() && i<= nums.length-1) //process the stack
        {
            while(nums[i]>nums[stack.peek()])
            {
               results[stack.pop()] = nums[i]; 
            }
            i++;
        }
        return results;
    }
}
