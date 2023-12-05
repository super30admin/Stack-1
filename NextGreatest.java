// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class NextGreatest {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0; i<2*nums.length; i++){
            if(!st.isEmpty() && i%nums.length == st.peek())
                break;
            while(!st.isEmpty() && nums[i%nums.length]>nums[st.peek()]){
                int popped = st.pop();
                res[popped] = nums[i%nums.length];
            }
            if(i<nums.length)
                st.push(i);
        }
        return res;
    }
}
