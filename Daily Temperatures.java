// Time Complexity :O(n)
// Space Complexity :O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        //edge 
        if(T==null || T.length==0) return T;
        int result[]=new int[T.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<T.length;i++)
        {
             while(!st.isEmpty() && T[i]>T[st.peek()])
             {
                 int idx=st.pop();
                 result[idx]=i-idx;
             }
            st.push(i);
        }
       return result;
    }
}
