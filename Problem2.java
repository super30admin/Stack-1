// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We go through the array twice as its circular array
//we use stack to push the indices lower than the current index
//when we find an element greater than the top of stack we pop and insert the greater one to the popped index
//we push to stack only n elements and avoid pushing repeated elements

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                res[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            } else if (i % n == st.peek()) {
                break;
            }
        }
        return res;

    }
}
