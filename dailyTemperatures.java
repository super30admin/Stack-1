class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] result = new int[n];
        if(temperatures == null || temperatures.length == 0) return result; 
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            while((!st.isEmpty()) && temperatures[i] > temperatures[st.peek()] ){
                int index = st.pop(); 
                result[index] = i - index;
            }
            st.push(i);
        }
        return result;
    }
}
