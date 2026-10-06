// O(2n) for adding into stack and removing time complexity
// O(n) for space complexity


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<n ; i++) {
            while(!st.empty() && temperatures[i] > temperatures[st.peek()] ){
               int prevIndex =  st.pop();
               result[prevIndex] = i -prevIndex;

            }
            st.add(i);
        }
        return result;
    }
}
