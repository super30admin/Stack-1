//Time Complexity = O(N)
//Space Complexity = O(N)

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
       Stack<Integer> st = new Stack<>();
       int n = nums.length;
       int[] result = new int[n];
       Arrays.fill(result, -1);

       for (int i = 0; i < 2 * n; i++) {
           int idx = i % n;
           while (!st.isEmpty() && nums[idx] > nums[st.peek()]) {
               int popped = st.pop();
               result[popped] = nums[idx];
           }
           if (i < n) {
               st.push(idx);
           }
       }
       return result;
    }

    public static void main(String[] args) {
        
        NextGreaterElements solution = new NextGreaterElements();
        int[] nums = {1, 2, 1};
        int[] result = solution.nextGreaterElements(nums);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}
