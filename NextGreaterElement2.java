class NextGreaterElement {
  /**
   * Time Complexity: O(n)
   * 
   *     2n -> to be exact
   * 
   * Space Complexity: O(n)
   * 
   * Were you able to solve this on leetcode? Yes
   */
  public int[] nextGreaterElements(int[] nums) {
        
    int[] res = new int[nums.length];
    Arrays.fill(res, -1);
    
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    
    for(int i = 1; i < nums.length; i++){
        while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
            res[stack.pop()] = nums[i];
            
        }
        stack.push(i);
    }
    
    // System.out.println(Arrays.toString(res));
    // System.out.println(nums[stack.peek()]);
    for(int i = 0; i < nums.length; i++){
        if(i == stack.peek()) break;
        while(!stack.isEmpty() &&  nums[stack.peek()] < nums[i]){
            // System.out.println("here:" + nums[i]);
            res[stack.pop()] = nums[i];
        }
    }
    
    return res;
  }
}
