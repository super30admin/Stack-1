// TC : O(n)
// SC : O(n)

// Using Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        if(temperatures == null || temperatures.length == 0) return new int[0];

        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for(int i =0; i<temperatures.length; i++){
            if( i == 0) st.push(i);
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}
