/*Running Time Complexity: O(2n)
Space Complexity: Omega(n)
Successfully Run and Compiled on leetcode.
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<temperatures.length;i++){
            while(!st.empty() && temperatures[st.peek()]<temperatures[i]){
                        int temp = st.pop();
                        res[temp] = i-temp;
                }
            st.push(i);
        }
        return res;
    }
}