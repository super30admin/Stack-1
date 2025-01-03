// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes


import java.util.Stack;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++){
            int t= temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0]){
                int[] pair = st.pop();
                res[pair[1]]= i-pair[1];
            }
            st.push(new int[]{t,i});
        }
        return res;
    }
}
