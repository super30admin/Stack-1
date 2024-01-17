import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
//        TC:O(3n)
//        SC:O(n)
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * n; i++){
            int idx = i % n;
            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[idx];
            }
            if(i < n)
                st.push(idx);
        }
        return result;
    }
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2 * n; i++){
            int idx = i % n;
            if(!st.isEmpty() && st.peek() == idx) break; // breaking through the for loop in 2nd iteration
            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[idx];
            }
            if(i < n)
                st.push(idx);
        }
        return result;
    }
}
