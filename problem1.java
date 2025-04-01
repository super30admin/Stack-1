// 739. Daily Temperatures
//Time Complexity: O(n)
//Space Complexity:O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int [] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int curr = temperatures[i];
            while(!st.isEmpty() && curr> temperatures[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = i-poppedIdx;
            }
            st.push(i);
        }
        return result;
    }
}