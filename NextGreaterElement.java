/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(n) size of the stack
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }
            if (i < n)
                st.push(i);
            else if (st.peek() == i % n)
                break;
        }

        return result;

    }
}