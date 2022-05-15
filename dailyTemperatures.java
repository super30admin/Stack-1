//TC: O(2n) = O(n) where n is the length of temperatures array
//SC: o(n) -> space used for stack

//CODE
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // null case
        if (temperatures == null || temperatures.length == 0)
            return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>(); // creating a stack of integers for storing indexes
        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) { // if the currr ele from temperatures
                                                                                 // is greater tha peek ele then pop
                                                                                 // from stack
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i); // push index into the stack
        }
        return result;
    }
}
