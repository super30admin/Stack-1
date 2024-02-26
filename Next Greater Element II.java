// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack();

        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for(int i = 0; i < nums.length; i++)
        {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()])
            {
                result[stack.pop()] = nums[i];
            }

            stack.push(i);
        }

        // Stack might have elements for which we couldn't find the next greater element to the right
        // As the array is circular let's traverse the array once again to check if we have any greater elements
        // Remember that if stack has any elements in it the elements would be ranging from smaller to bigger
        // from top to down

        // We are checking the condition if stack is empty outside bcoz in that case we don't need to traverse the array
        for(int i = 0; i < nums.length && !stack.isEmpty(); i++)
        {
            // We found the next greater element
            while(nums[stack.peek()] < nums[i]) result[stack.pop()] = nums[i];
        }

        return result;
    }
}