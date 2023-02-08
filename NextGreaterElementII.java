// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;
public class NextGreaterElementII {

        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> st = new Stack<>();
            int n = nums.length;
            int[] result = new int[n];
            Arrays.fill(result,-1);
            for (int i=0; i<n*2; i++){
                int idx = i%n;
               while (!st.isEmpty() && nums[idx] > nums[st.peek()]){
                   int popidx = st.pop();
                   result[popidx] = nums[idx];
               } 
               if (i<n){
                   st.push(i);
               }
            }
            return result;
            
        }
    
    
}
