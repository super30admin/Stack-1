class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] result = new int [nums.length];
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        Arrays.fill(result, -1); //O(n)
        for(int i = 0; i < 2*n ; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i % n];
                
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}

//TC: O(2n)
//SC: O(n)
