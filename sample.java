// Time Complexity :o(2n)->o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]result=new int[n];
        
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i]=-1;
            }else{
                   result[i]=st.peek();
            }
            st.push(nums[i]);

        }
      
        return result;

        
    }
}
// Time Complexity :o(n)
// Space Complexity :o(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]result=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& temperatures[i]>temperatures[st.peek()]){
                int idx=st.pop();
                result[idx]=i-idx;
            }
            st.push(i);
        }
        return result;

        
    }
}