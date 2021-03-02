class NextGreaterElement2 {
  
    /*
      Time : O(4N)
            1. Arrays.fill - N
            2. for loop - 2N
            3. Stack - N
       Space : O(N)  | Stack
       Leetcode : YES
    */
  
    /*
        follow same approach as Daily tempratures, just we need to find elements in left hand side as well,
        for which go through array one more time, 
        so first time you can find items on left, whatever you can't find would be left in stack,
        then second time if you can find greater elements for items in stack it will be on the left of that element. 
    
     */
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(result, -1);
        
        for(int i = 0 ; i < 2*n ; i++){
            
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i%n]){
                int idx = stk.pop();
                result[idx] = nums[i % n];
            }
            
            if(i < n){
                stk.push(i);
            }
        }
        
        return result;
    }
}
