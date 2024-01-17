// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            if (!st.isEmpty() && st.peek() == idx) break;
            while (!st.isEmpty() && nums[st.peek()] < nums[idx]) {
                int popped = st.pop();
                result[popped] = nums[idx];
            }
            if (i < n) {
                st.add(idx);
            }
        }
        return result;
    }

    public static void main(String[] args) {
       
        NextGreaterElement solution = new NextGreaterElement();
        int[] nums = {1, 2, 1};
        int[] result = solution.nextGreaterElements(nums);

       
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}
