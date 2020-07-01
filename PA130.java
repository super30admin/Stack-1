//Leetcode: 503. Next Greater Element II
//Time Complexity: O(2n)
//Space Complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums== null || nums.length==0) return nums;       
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res,-1);
        int n=nums.length;
        st.push(0);
        for(int i=1;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                Integer m = st.pop();                
                res[m] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return res;
    }
}