//Time complexity:O(n)
//Space complexity:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[] {};
        }
        Stack<Integer> st=new Stack();
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                int temp=st.pop();
                result[temp]=nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}