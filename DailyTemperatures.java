/*
Desc : We use a stack to keep a track of standing unresolved temperatures and whenever we encounter a resolving temperature we pop out the 
standing top of stack. 
Time Complexity : O(n)
Space Complexity : O(n)
*/
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
