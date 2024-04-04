/**
Utilize a stack to keep track of indices of temperatures.
Iterate through temperatures, popping indices from stack if the current temperature is greater, updating the result array.
Push the current index onto the stack.
TC-O(2n), SC- O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int poped = st.pop();
                res[poped] = i-poped;

            }
            st.push(i);
        }
        return res;

        
    }
}
