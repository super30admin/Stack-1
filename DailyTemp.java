//Time - O(n)
//Space - O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        if(T == null || T.length==0) return new int[0];
        int [] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<T.length; i++){
            while(!st.isEmpty()&& T[i] > T[st.peek()])
            {
                int curr = st.pop();
                result[curr] = i-curr;
            }
            st.push(i);
        }
        return result;
    }
}