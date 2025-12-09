// Time Complexity :O(4n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
Approach
We will be using a monotonic decreaseing stack, the idea it to put temp into a stack
till be find a temp that is higher then peek, then we start popping the elements and compaing them
and store the differnce of the popped index to cur in a different array

there might we the case where  the bigger number compared to cur came before so we go in a circular way
if we find to find element

return that array
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}