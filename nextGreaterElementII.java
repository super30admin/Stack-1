class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);

        for(int i = 0; i < (2*n); i++){

            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                result[st.pop()] = nums[i%n];
            }
         st.push(i%n);
        }
     return result;
    }
}