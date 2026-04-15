// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We initially fill the result array with -1 to handle the not applicable case as well. Now, we take a stack
and start pushing those elements where the current number is smaller than the stack's peek element. If not,
we iterate until stack has elements and current element is able to resolve them if it is greater. We take
modulo of the i to process in a circular manner and make sure to stay in bounds of array length. At any time,
if stack's peek becomes equal to the current element's index, we break as we already did traversal.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        int[] re = new int[n];
        Arrays.fill(re, -1);

        for(int i = 0 ; i < 2 * n ; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                re[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i % n);
            }
            else if (st.peek() == i % n)
                break;
        }

        return re;
    }
}