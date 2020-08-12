// Time complexity - O(n) (exact time complexity - 2n)
// Space complexity - O(n)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int []result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < T.length; i++){
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int idx = st.pop();
                result[idx] = i - idx;
            }
            
            st.push(i);
        }
        return result;
    }
}
