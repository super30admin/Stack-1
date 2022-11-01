public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        // null case
        if(T==null || T.length==0) return null;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!st.isEmpty() && T[i]>T[st.peek()]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
}

// Time Complexity - O(2n) = O(n)
// Space Complexity - O(n)