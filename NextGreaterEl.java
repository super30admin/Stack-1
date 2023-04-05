import java.util.*;
public class NextGreaterEl {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(nums==null||nums.length==0)return new int[n];

        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }

}
