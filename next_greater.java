//Optimized Approach : Monotonic stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        
        if(nums == null || nums.length == 0)
            return result;
        if(nums.length == 1)
            result[0] = -1;
        
        //Fill all elements of result as -1;
        Arrays.fill(result, -1);
        
        //stack contains index nos
        Stack<Integer> stack = new Stack<>();
        
        //circular array so we have to traverse twice so len = 2* n
        for(int i=0; i< 2 * nums.length; i++){
            while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }
            
            if(i < nums.length)
                stack.push(i);
        }
        return result;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(n)