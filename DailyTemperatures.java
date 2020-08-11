// Time Complexity: O(2n) -> n to traverse the array and n steps to resolve each temperature
// Space Complexity: O(n) -> n - size of the stack

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0) return new int[0];

        Stack<Integer> st = new Stack<>(); // to store indices of unresolved temperatures

        int[] result = new int[T.length];

        for(int i = 0 ; i < T.length ; i++){

            while(!st.isEmpty() && T[i] > T[st.peek()]){ // if the incoming temperature can resolve the top element in the stack
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);

        }

        return result;
    }
}
