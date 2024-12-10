class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int [] res = new int[n];
        int idx=-1;
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                idx=st.pop();
                res[idx]=nums[i%n];
            }
            if(i<n)
            st.push(i);
        }
        while(!st.isEmpty())
            res[st.pop()]=-1;
        return res;
    }
}
