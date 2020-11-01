//Time:O(N)
//Space:O(N)

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < temp.length; i++) {

            while (!st.isEmpty() && temp[st.peek()] < temp[i]) {
                ans[st.peek()] = st.isEmpty() ? 0 : i - st.peek();

                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}