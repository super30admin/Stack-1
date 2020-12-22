//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //edge
        if(nums==null|| nums.length==0) return nums;
        int result[]=new int[nums.length];
        Arrays.fill(result,-1);
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<2*n;i++)
        {
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()])
            {
                int idx=st.pop();
                result[idx]=nums[i%n];
            }
            if(i<n)
            {
                 st.push(i);
            }
           
        }
        return result;
    }
}
