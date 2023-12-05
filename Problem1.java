//Time Complexity : O(n) 
//Space Complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];
        int[] result = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<T.length; i++){
            int curr = T[i];
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}
