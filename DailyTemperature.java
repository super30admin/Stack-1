//Time O(n)
//Space O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result;
        int n = temperatures.length;
        result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i])
                result[st.peek()]= i-st.pop();
            st.push(i);
        }
        return result;
    }
}