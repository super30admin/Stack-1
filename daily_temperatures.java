//TC: O(n)
//SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int [] result=new int [n];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
           while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()])
           {
            int curr=st.pop();
            result[curr]=i-curr;
           }
           st.push(i);
        }
        while(!st.isEmpty())
        {
            result[st.pop()]=0;
        }
        return result;
    }

}