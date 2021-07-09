//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        
         
        Stack<Integer> s1 = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        s1.add(0);
        for(int i = 1; i < 2*n; i ++){
            
            if(!s1.isEmpty() && nums[i%n] > nums[s1.peek()]){
                
                while(!s1.isEmpty() && nums[i%n] > nums[s1.peek()]){
                    
                    int temp = s1.pop();
                    result[temp] = nums[i%n];
                }
                //s1.add(i);
            }
            
          
              if(i < n){
                 s1.add(i); 
              }
              
          
                
            
        }
        return result;
        
    }
}