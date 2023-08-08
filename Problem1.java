// Time: O(n)
// Space: O(n)



class Solution {
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