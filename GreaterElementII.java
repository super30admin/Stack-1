// Time Complexity : O(4n)
// Space Complexity : O(n)
//  n is the number of elements in given nums array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //null check
        if(nums == null || nums.length == 0)
            return new int[]{};
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        for(int i =0 ; i < 2*n ; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i <n)
                st.push(i%n);
        }
        return result;
    }
}
