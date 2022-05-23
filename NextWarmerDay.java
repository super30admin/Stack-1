public class NextWarmerDay {
  /**
   * Time complexity: O(n)
   *    2n - to be exact
   * 
   * Space complexity: O(1)
   * 
   * Were you able to solve this on leetcode? yes
   * 
  */
  public int[] dailyTemperatures(int[] temperatures) {
        
    int[] res = new int[temperatures.length];
    
    Deque<Integer> stack = new ArrayDeque<>();
    
    stack.push(0);
    
    for(int i = 1; i < temperatures.length; i++){
        while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
            int top = stack.pop();
            res[top] = i - top;
        }
        stack.push(i);
    }
    
    return res;
  }
}
