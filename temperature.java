// TC = O(n)
// SC = O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if( T == null || T.length == 0 ) return new int[0];
        Stack<Integer> st = new Stack<>();
        int[] r = new int[T.length];
        for(int i = 0; i < T.length; i++){
            while(!st.isEmpty() && T[i]>T[st.peek()]){
                int popped = st.pop();
                r[popped] = i - popped;

            }
            st.push(i);

        }
        return r;
    }
}