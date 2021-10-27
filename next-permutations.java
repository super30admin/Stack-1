//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i = 0; i < 2*n; i++) {
            //if the incoming number is greater, we can resolve the top element of the stack
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}