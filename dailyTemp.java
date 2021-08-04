// Time: O(n)
//Space: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0) return result;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int resolved = st.pop();
                result[resolved] = i - resolved;
            }  
            st.push(i);
        }
        return result;
    }
}