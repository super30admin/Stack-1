// tc = O(n)
// sc = O(n)

public class NextGreaterElem {

}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // if(nums == null && nums.length == 0) return -1;
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
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