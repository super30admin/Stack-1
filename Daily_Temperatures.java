class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        
        if(temperatures == null || temperatures.length == 0) return result;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
                
            }
            st.push(i);
        }
        
        return result;
        
    }
}

//Time: 31 ms (73.10%), Space: 48.3 MB (95.85%)
//TC: O(N)
//SC: O(N)
