// TC: O(2N)
// SC: O(1)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;

            }

            st.push(i);
        }
        return result;
    }
}
