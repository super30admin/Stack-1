//T.C: O(N);
//S.C: O(1);
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st=new Stack<>();
        int[] ans= new int[temperatures.length];
        for(int i =0 ; i<temperatures.length;i++){
            while(!st.empty() && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()]=i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}