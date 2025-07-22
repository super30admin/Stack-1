//Time complexity: O(2n) -> O(n)
//Space complexity: O(n) - worst case
//Here worst case would be decreasing array

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            st.push(i);
        }
        return result;
    }
}