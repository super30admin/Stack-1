class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Stack<Integer> forward = new Stack<>();
        Stack<Integer> backward = new Stack<>();
        
        int len = nums.length;
        int[] result = new int[len];
        
         boolean[] filled = new boolean[nums.length];
        
         Arrays.fill(result,-1);
        
        for(int i = len - 1; i >= 0; i--){
            
            //The stack needs to be decreasing.
            
            while(!backward.isEmpty() && backward.peek() <= nums[i]){
                backward.pop();
            }
            
            if(!backward.isEmpty()){
                
                result[i] = backward.peek();
                filled[i] = true;
                
            }
            
            
            backward.push(nums[i]);
            
        }
        
        for(int i= len - 1; i >= 0; --i){
            if(!filled[i]){
                while(!backward.isEmpty() && nums[i] >= backward.peek()) backward.pop();
                if(!backward.isEmpty()){
                    result[i] = backward.peek();
                    filled[i] = true;
                }            
            }            
        }  
        
        return result;
    }
}