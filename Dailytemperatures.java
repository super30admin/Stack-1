// Time Comp: O(n)
// Space Comp: O(n)
public class Dailytemperatures {
    public int[] dailyTemperatures(int[] t) {
        int[] result = new int[t.length];
        Arrays.fill(result, 0);
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<t.length; i++){
            while(!st.isEmpty() && t[st.peek()] < t[i]){
                int idx = st.pop();
                result[idx] = i-idx;
            }
            st.push(i);
        }
        return result;
    }
}
