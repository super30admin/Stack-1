// Time complexity - O(n)
// space complexity - O(n)
// Solved on leetcode - yes
// faced any issues - No
// Travesing util the greater elemnt is found and adding into the stack, if greater is found, pop an element and compare with each element in the stack and update the result
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        int currentIndex = 0;
        for(int i=0;i<2*n;i++) {
            System.out.print(i + " ");
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
            System.out.println(nums[stack.peek()]);
                result[stack.peek()] = nums[i%n];
                stack.pop();
            }
            if(i<n)
            stack.push(i%n);
        }
         while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
