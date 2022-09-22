class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>st= new Stack();
         int[] ans= new int[nums.length];
        
        
        for(int i=0;i<2*nums.length;i++){
            
            if(!st.isEmpty()&&st.peek()!=i%nums.length){
                
                while(!st.isEmpty() && nums[st.peek()]<nums[i%nums.length]){
                    
                  ans[st.pop()]=nums[i%nums.length];  
                    
                }
               if(i<nums.length){ st.add(i%nums.length);}
                
                
            }else{
                st.add(i%nums.length);
                  
            }   
        }
        //System.out.println(st);
        while(!st.isEmpty()){
            ans[st.pop()]=-1;
        }
        return ans;
        
    }
}
