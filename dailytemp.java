//SC: O(n)
//TC: O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==0 || temperatures == null){
            return new int[] {};
        }
   
        if( temperatures.length == 1) return new int[] {};
   
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
   
        for(int i =0 ; i< n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int idx = s.pop();
                result[idx] = i - idx;
            }
            s.push(i);
        }
        return result;
       }
   }