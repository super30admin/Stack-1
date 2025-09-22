// Time Complexity: O(n) — iterate 2n indices; each index is pushed once and popped at most once from the stack.
// Space Complexity: O(n) — stack of indices (and the output array).

// Maintain a decreasing monotonic stack of indices; initialize result[] with -1.
// For i = 0..2n-1, let x = nums[i % n]; while stack not empty and x > nums[stack.peek()], set result[stack.pop()] = x.
// If i < n, push i onto the stack so first pass captures each index; circularity is handled via i % n.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < 2 * n; i++) {

            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i % n];
            }

            if(i < n)
                st.push(i);
            else if(st.peek() == i % n)
                break;
        }

        return result;
    }
}
