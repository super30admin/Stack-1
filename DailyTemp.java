//TC = O(n)
//SC = O(1)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int[] res  = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int popped = st.pop();
                res[popped] = i-popped;
            }
            st.push(i);
        }
        return res;
    }
}