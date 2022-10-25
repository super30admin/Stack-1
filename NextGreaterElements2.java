// Time complexity: O(n)
// Space complexity: O(n)

// Approach: Monotonous Decreasing Stack Pattern. Basically we will iterate through the array and everytime we find a decreasing element (by comparing it to top of stack), we can add it to the stack (we add the index to the stack), but if we find an increasing element (greater than top of stack), we pop until we find a greater element in the stack.


class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int[] result = new int[nums.length];
       Arrays.fill(result,-1);
       Stack<Integer> stack = new Stack<>();
       int count = 1;
       for (int i = 0; i < 2*nums.length; i++) {
           // even this way works instead of modulus
           // if (i == nums.length && count == 2) {
           //     break;
           // }
           // if (i == nums.length) {
           //     count++;
           //     i = 0;
           // }
           while (!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]) {
               int index = stack.pop();
               result[index] = nums[i%nums.length];
           }
           stack.push(i%nums.length);
       }
       return result;
    }
}