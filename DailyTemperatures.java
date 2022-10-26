// TC = O(N)
// SC = O(N)

// approach: monotonic stack increment
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //null case
        if (temperatures == null || temperatures.length ==0) return new int[0];
        
        int [] result = new int[temperatures.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int j = st.pop();
                result[j] = i - j;
            }
            st.push(i);
        }
        
        return result;
    }
}
