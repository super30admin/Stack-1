package Stack-1;

public class problem1 {
    class Solution {
        //TC:- O(n)
        //SC:- O(n)
        public int[] dailyTemperatures(int[] T) {
            if(T == null || T.length == 0) return new int[] {};
            
            int n = T.length;
            Stack<Integer> st = new Stack<>();
            int[] result = new int[n];
            
            for(int i = 0; i < n; i++){
                while(!st.isEmpty() && T[i] > T[st.peek()]){
                    int index = st.pop();
                    result[index] = i -  index;
                }
                st.push(i); 
            }
            
            return result;
            
        }
    }
}
