//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        
        
        Stack<Integer> s1 = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        s1.add(0);
        for(int i = 1; i < n; i ++){
            
            if(!s1.isEmpty() && temperatures[i] > temperatures[s1.peek()]){
                
                while(!s1.isEmpty() && temperatures[i] > temperatures[s1.peek()]){
                    
                    int temp = s1.pop();
                    result[temp] = i - temp;
                }
                s1.add(i);
            }
            
            else{
                
                s1.add(i);
            }
        }
        return result;
    }
}