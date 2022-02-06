// Time Complexity: O(2n) -> O(n)
// Space Complexity: O(n)
// Monotonic Stack
public class DailyTemeratures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return temperatures;
        
        Stack<Integer> st = new Stack<>();
        int [] result = new int[temperatures.length];
        
        for(int i = 0 ; i < temperatures.length; i++)
        {
            // avoid NPE for first val temp[top] < temp[i]
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
            {
                int top = st.pop();// removed as solved
                result[top] = i - top;
            }
            st.push(i); // this could be smaller for next possible 
        }
        
        return result;
    }
}
