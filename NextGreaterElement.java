Time Complexity = O(n)
Space Complexity = O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        
        for(int i = 1; i < 2*nums.length; i++){
            int j = i%nums.length;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                result[stack.pop()%nums.length]=nums[j];
            }
            stack.push(j);
        }
       return result; 
    }    
}