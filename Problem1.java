package Stack-1;
// TC: O(2*n)
// SC: O(n)
public class Problem1 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n=temperatures.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }

        return result;
    }
}
