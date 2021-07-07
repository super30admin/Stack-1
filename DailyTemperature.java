//TC : O(n) - length of T
//SC : O(n) - space of stack

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0 || T == null)
            return result;
        
        Stack<Integer> st = new Stack<>();
       
        
        for(int i=0;i<T.length;i++){
            
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i-idx;
                
            }
            
         
            st.push(i);
            
        }
        
        return result;
    }
}