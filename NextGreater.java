// Time Complexity :3 o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no 


// Your code here along with comments explaining your approach: using monotonic stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        
        for(int i = 0;i< 2*nums.length;i++)
        {
           
            while(!st.isEmpty() && nums[i%nums.length]> nums[st.peek()])
            {
                int popped =  st.pop();
                result[popped] = nums[i%nums.length];
            }
            if(i< nums.length){
                 st.push(i);
            }
           
        }
        
        return result;
        
    }
}
