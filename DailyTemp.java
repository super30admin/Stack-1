//TC = O(2*n) --> O(n)
//SC = O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int [] result = new int[temperatures.length];
        
        if(temperatures == null || temperatures.length == 0)
            return result;
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i< temperatures.length; i++){
            
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                
                int index = s.pop();
                result[index] = i - index;
                
            }
            s.push(i);
        }
        
        return result;
            
        
    }
}