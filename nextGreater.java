import java.util.Arrays;
import java.util.Stack;
//TC O(2n) SC On

public class nextGreater {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] re = new int[n];
        Arrays.fill(re, -1);
        Stack<Integer> st = new Stack();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                int popped = st.pop();
                re[popped] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return re;
    }
}
