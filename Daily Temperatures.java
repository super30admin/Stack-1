//TC = O(n)
//SC =O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return null;
        int result[] = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
            {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result; 
    }
}
