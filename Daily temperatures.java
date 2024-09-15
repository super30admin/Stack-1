// Time complexity - 0(n)
// space complexity - 0(n) list of daily daily Temperatures

class Solution {
    public int[] dailyTemperatures(int[] T) {
     int [] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i- idx;
            }
            st.push(i);
        }
        return result;
    }
}