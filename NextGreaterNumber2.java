// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will run a loop of size 2n from bacwards
// To have valid indices we will always take %n for accessing the array elements
// If we see a lesser element in stack we will pop it out
// Otherwise we will keep adding the cur no. to the stack
// if we see taht top of stack is greater than current we will add it to result
// Otherwise add -1 to the result array. Finally return the result array.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2 * n - 1; i >=0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            res[i%n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i%n]);
        }
        return res;
    }
}