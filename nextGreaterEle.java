/*time complexity O(2n)
space complexity O(n)*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<2*nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%(nums.length)]){
                int idx=st.pop();
                result[idx]=nums[i%nums.length]; 
            }
            if(i<nums.length){
                 st.push(i);
            }
           
        }
        return result;
    }
}