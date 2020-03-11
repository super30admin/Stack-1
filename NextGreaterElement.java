//Time Complexity: O(2n)
//Space Complexity: O(n) for Stack
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0) return result;
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<Integer>();
        int n = nums.length;
        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}
