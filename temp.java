/* Time complexity: O(n)
space complexity: O(n)
*/

class Solution{
    public int[] dailyTemperatures(int[] T){
        if(T == null || T.length ==  0) return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0; i<T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i-idx;
            }
            st.push(i);
        }
        return result;
    }
}