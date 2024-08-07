//TC - O(n)
//SC - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);

        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int popped = st.pop();
                res[popped] = nums[i % n];
            }
            if(!st.isEmpty() && i % n == st.peek()){
                break;
            }
            if(i < n){
                st.push(i);
            }
        }
       return res; 
    }
}
