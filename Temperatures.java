// Time Complexity :O(n) where n is length of the temperatures array
// Space Complexity :O(n) where n is length of the temperatures array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.Stack;
public class Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length < 1){
            return null;
        }
        int len = temperatures.length;
        int[] result = new int[len];

        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int popped = st.pop();
                result[popped] = i-popped;
            }
            st.push(i);
        }
        return result;
    }
}
