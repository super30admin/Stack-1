/*
Time Complexity : O(n)
Space Complexity :O(n)
Did this code successfully run on Leetcode : yes
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i=0 ; i<temperatures.length ; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    answer[st.peek()] = i-st.peek();
                    st.pop();
            }
            st.push(i);
        }
        return answer;
    }
}
