//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0) return T;
        Stack<Integer> st = new Stack<>();
        int[] ans= new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[st.peek()]<T[i]){//adding to the stack the elements whose greater has not been found yet
                int index=st.pop();    
                ans[index]= i-index;
            }
            st.push(i);
        }
        
        return ans;
        
    }
}