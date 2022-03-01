//tc: O(n)
//sc: O(n)
import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);
        for(int i=0; i<n*2; i++){
            int curr = nums[i%n];
            if(i > n){
                if(!st.isEmpty() && st.peek() == i){
                    break;
                }
            }
            while(!st.isEmpty() && curr > nums[st.peek()]){
                int idx = st.pop();
                res[idx] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return res;
    }
}