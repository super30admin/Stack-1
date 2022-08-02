class Solution {
  //TC:O(2n) SC:O(n)
    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(result,-1); 
        //check if stack top element is less than current index element,then place current element in result 
      //i< 2n because we might have to check second time for any gretaer element 
        for(int i=0;i<2*nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%nums.length]){
                int indx=st.pop();
                result[indx]=nums[i%nums.length];
            }
            if(i<nums.length){
            st.push(i);
            }
        }
        return result;
    }
}
