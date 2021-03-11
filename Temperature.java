//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Push the temp values in the stack check if the incoming element can resolve it
// if it does take tne difference and store it in result array
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int len = T.length;
        int[] result = new int[len];
        if(len == 0) return result;
        
        for(int i=0; i < len; i++)
        {
            while(!st.isEmpty())
            {
                if(T[i] > T[st.peek()]){
                    int ind = st.pop();
                    result[ind] = i - ind;
                }
                else
                    break;
            }
            st.push(i);
        }
        return result;
    }
}