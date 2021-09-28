/*
Time complexity: O(N) {2N as we are traversing both array and stack, but all in all will be n}
Space complexity: O(N) as we are using stack
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Base:
        if(temperatures.length == 0 || temperatures == null){
            return new int[]{};
        }
        //Logic
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
           while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
            int idx = s.pop();
               result[idx] = i - idx;
             } 
            s.push(i);
        }
        
        return result;
    }
    
}
