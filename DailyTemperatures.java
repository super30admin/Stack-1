class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int cur = temperatures[i];
            while(!st.isEmpty() && cur > temperatures[st.peek()])
            {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
         }
         return res;
    }
}

//tc: O(n)
//sc: O(n)
