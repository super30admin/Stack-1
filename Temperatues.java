class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&& temperatures[st.peek()]<temperatures[i]){
                int index = st.pop();
                res[index] = i-index;
                
            }//while
            st.push(i);
        }//for

        return res;

    }
}