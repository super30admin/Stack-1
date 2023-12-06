// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class NextGreaterElementTwo {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            Arrays.fill(result, -1);
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for(int i = 1; i < 2*n; i++){
                while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                    int popped = stack.pop();
                    result[popped] = nums[i%n];
                }
                if(i < n)
                    stack.push(i%n);
            }
            return result;
        }
    }
}
