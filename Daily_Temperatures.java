// TC : O(n)
// SC : O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        if(temperatures == null || temperatures.length == 0)
            return new int[]{};
        
        int n = temperatures.length;
        
        int[] result = new int[n];
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
           while(!st.isEmpty()) {
                if(temperatures[st.peek()] < temperatures[i]) {
                    int num = st.pop();
                    result[num] = i - num;
                }
               else
                   break;
           }
            st.push(i);
        }
        return result;
    }
}
