// Approach: Maintain a monotonic decreasing stack to be resolved. Put the indexes in
// stack.
// Iterate over the list from 0 to 2n but only access idx = i%n
// Check if next element is greater, if smaller or equal push in the stack to resolve
// it later. If greater pop() and result[poppedIdx] = currNum in array (which is greater)
// than element on top of stack.
// Time: O(n)
// Space: O(n)

import java.util.*;

class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        if (nums.length == 0) return result;
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack();

        for (int i = 0; i<2*n; i++) {
            int idx = i%n;
            while (!st.isEmpty() && nums[idx] > nums[st.peek()]) {
                int popIdx = st.pop();
                result[popIdx] = nums[idx];
            }
            if (i < n) st.push(i);
        }
        return result;
    }
}