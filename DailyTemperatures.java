//TC - O(N)
//SC - O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[]{};
        }
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int popped = st.pop();
                answer[popped] = i - popped;
            }
            st.push(i);
        }
        return answer;
    }
}