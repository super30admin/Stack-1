import java.util.Arrays;
import java.util.Stack;

//Time Complexity=O(n)
//Space Complexity=O(n)
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;

        int[] result=new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int temp=st.pop();
                result[temp]=nums[i%n];

            }
            st.push(i%n);
        }

        return result;
    }
}
