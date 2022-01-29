import java.util.*;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Sample{
    public int[] dailyTemperatures(int[] temperatures) {
        //o(n) time and o(n) space
        Stack<Integer> st= new Stack<>();
        int[] res = new int[temperatures.length];
        if(temperatures.length == 0 || temperatures == null) return res;
        st.push(0);
        
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int temp = st.pop();
                res[temp] = i - temp;
            }
            st.push(i);
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        //o(n) time and o(n) space
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        if(nums.length == 0 || nums == null) return res;
        Arrays.fill(res, -1);
        st.push(0);
        for(int i = 0; i < (2 * nums.length); i++){
            while(!st.isEmpty() && nums[i%nums.length] > nums[st.peek()]){
                int top = st.pop();
                res[top] = nums[i % nums.length];
            }
            if(i < nums.length) st.push(i);
        }
        return res;
    }
    

}