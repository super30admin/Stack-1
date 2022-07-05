TC: O(n)
SC:O(n)
Successfully run on leetcode

used a stack to store the min temperature always at the top and popped it when we found the next highesttemperature

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st = new Stack<>();
        int [] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int cur = st.pop();
                result[cur] = i-cur;
                
            }
            st.push(i);
        }
        return result;
    }
}