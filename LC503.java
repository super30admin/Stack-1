class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums.length == 0 || nums == null){
            return new int[0];
        }
        
        int output[] = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        Arrays.fill(output, -1);
        
        for(int i = 0; i < nums.length*2; i++){
            
            int x = i % nums.length;
            while(!stack.isEmpty() && nums[x] > nums[stack.peek()]){
                int top = stack.pop();
                output[top] = nums[x];
            }
            
            if(output[x] == -1){
                stack.push(x);
            }
        }
        return output;
    }
}

//Time : O(n)
//Space : O(n)