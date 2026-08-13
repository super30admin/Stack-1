/**
 * Time Complexity:  O(n)  where n is the number of days
 * Space Complexity: O(n) size of the stack
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                result[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        return result;

    }
}