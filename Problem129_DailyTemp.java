//Time Complexity: O(2n) ~ O(n)
//Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        //base case
        if(T == null || n == 0)
            return result;
        
        Stack<Integer> st = new Stack();
        
        for (int i = n - 1; i >= 0; --i) {    
            //till stack is not empty and incoming temp is greater than top
            while (!st.isEmpty() && T[i] >= T[st.peek()]) 
                //pop the stack element
                st.pop();
            //edge case: if empty -> 0
            if(st.isEmpty()){
                result[i] = 0;
            }//else subtract the indices of peek element and i
            else{
                result[i] = st.peek() - i;
            }
            //push incoming element
            st.push(i);
        }
        
        return result;
    }
}