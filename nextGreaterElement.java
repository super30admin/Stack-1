class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int index = st.pop();
                res[index] = nums[i%n];
            }//while
            if(i<n){
                st.push(i);
            }//if
        }//for

        return 
        
    }
}