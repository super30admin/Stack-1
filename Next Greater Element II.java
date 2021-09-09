class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;
        Arrays.fill(ans,-1);

        for(int i=0 ; i<2*n ; i++)
        {

            while(!st.isEmpty() && nums[i%n] > nums[st.peek()])
            {
                ans[st.peek()] = nums[i%n];
                st.pop();
            }

            if(!st.isEmpty() && nums[i%n] < nums[st.peek()])
            {
                st.push(i%n);
            }

            if(i<n) st.push(i);

        }

        return ans;

    }
}
