// Time Complexity : O(2 * n)
// Space Complexity : O(1)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0)
            return res;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int j = st.pop();
                res[j] = i - j;
            }
            st.push(i);
        }
        return res;
    }
}