/*
Space: O(n) size of stack used
Time: O(n) traverse temperatures array once
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] temps = new int[n];
        
        //Base:
        if(temperatures==null || temperatures.length==0){
            return temps;
        }
        
        //Logic:    
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<n; i++){
            // System.out.println("temperatures[i]: "+ temperatures[i]);
            int currTemp = temperatures[i];
                while(!s.isEmpty() && currTemp > temperatures[s.peek()]){
                int lowTempIdx = s.pop();
                temps[lowTempIdx] = i-lowTempIdx;
                }
             s.push(i);
        }
       return temps; 
    }
}
