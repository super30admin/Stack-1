/*
Time: O(N)
Space: O(N)
Approach:
========
1. Iterate through array twice because it is circular, and to calculate next greater element for last one,
array has to be traversed again
2. For every element, until stack is empty or stack's top is less than num, pop from stack and update next greater element at that 
index to current value
3. Push to stack if not already done
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if( nums == null || nums.length == 0) return new int[]{}; 
       
        int[] result = new int[nums.length]; 
        int n = nums.length; 
        //fill array with -1, as default is -1
        Arrays.fill(result, -1); 

        Stack<Integer> stack = new Stack<>();
        // iterate through array twice (circular)
        for(int i = 0; i < 2*n; i++) {
            // get value at index
            int num = nums[i%n]; 
            // until stack is not empty and value on top of stock is less than number, pop and update
            //value at index to current number
            while(!stack.isEmpty() && nums[stack.peek()] < num)
                result[stack.pop()] = num;
            // push to stack if index less than n
            if(i < n)
                stack.push(i); 
        }
        return result;
    }
}