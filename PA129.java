//Leetcode: 739. Daily Temperatures
//Time complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0) return T;
        int[] res = new int[T.length];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<T.length;i++){
            while(!st.isEmpty() && T[st.peek()] < T[i]){
                int n= st.pop();
                res[n]= i-n;
            }
            st.push(i);
        }
        
        return res;
    }
}