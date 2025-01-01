// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    //TC:O(2N)+O(N)
    // SC:O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //O(N)
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            st.push(i%n);
        }

        return result;
    }
}
