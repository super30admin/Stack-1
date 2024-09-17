/*
The time complexity is O(N) where N is the number of elements and the space complexity is also O(N)

Here the intuition is to check the eligible candidates if there are greater than our present candidate. The eligible candidate indexes
are stored inside the stack. For every check if its not eligible we remove it from the stack. If the stack is empty then the highest element
will be -1. Since we should also consider the rotated indexes we loop through 2*N so if we reach the 0 index we again start from N-1 index.

Yes, the solution passed all the test cases in leetcode.
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[length];

        for(int i=2*length-1;i>=0;i--){


            //Checking the conditions of stack.
            while(!stack.isEmpty() && nums[i%length]>=nums[stack.peek()]){stack.pop();}
            if(stack.isEmpty()){
                ans[i%length] = -1;
            }
            else{
                ans[i%length] = nums[stack.peek()];
            }

            //Push the current index into stack.
            stack.push(i%length);
        }

        return ans;
    }
}