/*
Space: O(n) stack is built
Time: O(n) for array traversal twice 2n ~ n
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Base:
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        
        //Logic:
        int n = nums.length;
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack();

        for(int i = 0 ; i< 2*n ; i++){
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                result[s.pop()] = nums[i%n];
                
            }
            //left out elements if any
            if(i<n){
                s.push(i);    
            }
        }
        while(!s.isEmpty()){
            result[s.pop()] = -1;
        }

        return result;
    }
}
