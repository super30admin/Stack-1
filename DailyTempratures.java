class DailyTemprature {
  
    /*
      Time : O(2N) | 
            worst case we will put every element in the stack, so after for loop, we will again touch each element via stack.
      Space : O(N) | stack space
      Leetcode : YES
    */
  
    /*
      Approach :
      As you traverse through left,
      LAST unresolved item gets chance to get resolved FIRST. LIFO ---> use stack.
      as you traverse, iterate through stack, check if we can resolve items in stock, if yes good,
      if not then put curr item in stack,
      in the mark whatever in the stack as unresolved and return
    */
    public int[] dailyTemperatures(int[] T) {
        int[] result;
        if(T == null || T.length == 0) return T;
        int n = T.length;
        result = new int[n];
        Stack<Integer> stk = new Stack<>();
        
        
        for(int i = 0; i < n; i++){            
            while(!stk.isEmpty() && T[stk.peek()] < T[i]){
                int indx = stk.pop();
                result[indx] = i - indx;
            }            
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            result[stk.pop()] = 0;
        }
        
        return result;
    }
}
