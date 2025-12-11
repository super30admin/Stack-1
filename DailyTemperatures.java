// 739. Daily Temperatures
// https://leetcode.com/problems/daily-temperatures/description/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int[] answer = new int[temperatures.length];

        for(int i = 0 ; i < temperatures.length ; i++){

            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                answer[st.peek()] = i - st.pop();
            }

            st.push(i);
        }

        return answer;
    }
}