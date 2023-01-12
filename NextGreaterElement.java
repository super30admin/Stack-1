// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

// Your code here along with comments explaining your approach
// I have used the stack to determine the next largest element,
//i.e I have stored all the previous eleents in the stack which did not see a greater element 
//popped it from the stack only when there exist a greater element to it,
//In the second iteration, we only check for the elements which did not see the greater element in the first ieteration,
// as we are following a cyclic array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // base case
        if (nums.length == 1)
            return new int[] { -1 };
        // logic
        Stack<Integer> ans = new Stack<>();
        int[] a = new int[nums.length];
        Arrays.fill(a, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!ans.isEmpty()) {
                int ind = ans.peek();
                if (nums[i] > nums[ind]) {
                    a[ans.pop()] = nums[i];
                } else {
                    break;
                }
            }
            ans.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!ans.isEmpty()) {
                int ind = ans.peek();
                if (nums[i] > nums[ind]) {
                    a[ans.pop()] = nums[i];
                } else {
                    break;
                }
            }
            if (a[i] == -1)
                ans.push(i);
        }
        while (!ans.isEmpty()) {
            a[ans.pop()] = -1;
        }
        return a;
    }
}