class Solution {
    //tc- o(n) //sc-o(n)
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return null;
        int n = T.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<T.length;i++)
        {      
        while(!st.isEmpty()&& T[i] > T[st.peek()])
        {
            int popped = st.pop();
            result[popped] = i-popped;
        }
        st.push(i);
        }
        return result;
    }
}