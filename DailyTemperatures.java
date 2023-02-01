// Time Complexity : O(n)
// Space Complexity : O(n)

/*
 * we traverse though the array and until we find an element greater than
 * the one we have it in stack we add the elements and move to next.
 * once we find it we append the difference in their index to the result.
 */

 class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                answer[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return answer;
    }
}