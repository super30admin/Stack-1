class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        //Create a stack for pushing the temperatures.
        
        Stack s = new Stack();
        
        int len  = temperatures.length;
        
        int[] ans = new int[temperatures.length];
        
        for(int i = len - 1; i >= 0 ; i--){
             
            
            
            
            while(!s.isEmpty() && temperatures[(int)s.peek()] <= temperatures[i]){
                 
                s.pop();
                 
            }
            
            if(s.isEmpty()){
                ans[i] = 0;
            }
            
            else{
                ans[i] = (int)s.peek() - i;
            }
            s.push(i);
        }
        
        return ans;
    }
}