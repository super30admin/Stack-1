//TC: O(n)
//SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int n=nums.length;
        int [] result=new int [n];
        int j;
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<2*n;i++)
        {
           j=i%n;
           while(!st.isEmpty()&&nums[j]>nums[st.peek()])
           {
            int curr=st.pop();
            result[curr]=nums[j];
           }
           if(i<n)
           st.push(i);
        }
        while(!st.isEmpty())
        {
            result[st.pop()]=-1;
        }
        return result;
        
    }
}