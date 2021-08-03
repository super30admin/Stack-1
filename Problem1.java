
// time - O(n)
// space - O(n)




class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int [] result = new int[temperatures.length];

        int n = temperatures.length;

        if(temperatures == null || temperatures.length == 0) return result;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {

                int top = st.pop(); // get the top element index
                result[top] = i - top; // difference between ith index and top index

            }

            st.push(i);


        }

        return result;

    }
}