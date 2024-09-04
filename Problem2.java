//Time = O(n)
//Space = O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // initialize result array with -1
        Arrays.fill(res, -1);

        // traverse the array twice
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            // process the next greater element for the top element in the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }

            // push current index to the stack
            if (i < n) {
                stack.push(i);
            }
        }

        return res;
    }
}
