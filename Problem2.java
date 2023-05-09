class Problem2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length; 
        int result[] = new int[n];
        Arrays.fill(result, -1);
        for(int i = 0; i < 2 * n; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i % n] ;
            }
            if(i < n)
                st.push(i);
            if(i > n && i % n == st.peek())
                break; 
        }
        return result;
    }
}


