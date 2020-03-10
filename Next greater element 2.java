// Time complexity - 0(2n)
// space complexity - 0(n)


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] result = new int[nums.length];
        if(nums == null || nums.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){ // Checking circular if elements are presnt are not. so it is 2n.
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i< n) st.push(i);
        }
        return result;
    }
}