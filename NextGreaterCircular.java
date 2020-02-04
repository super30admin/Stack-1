/**
LeetCode Submitted : YES
Time Complexity : O(2N)
Space Complexity : O(N)

The idea is to traverse the array list twice so we find all the possible elements in circular traversal fashion. For keeping track of next greater element we use Stack and we pop elements from stack if its value is less than current element. We call this recursively (through while loop) at each iteration. Lastly, we add current element to the stack.In the second pass we follow the same process without adding it to the stack.

**/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> s = new Stack<>();
        int[]result = new int[nums.length];
        
        Arrays.fill(result,-1);
        
        if(nums == null || nums.length < 1)
            return result;
        
        //Push first index to stack
        s.push(0);
        
        //Iterate first loop to find next greater element without circular condition
        for(int i = 1; i<nums.length;i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                result[s.pop()] = nums[i];
            }
            s.push(i);
        }
        
        
        //Iterate with second pass to handle circular traversal of elements
        for(int i = 0; i<nums.length;i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                result[s.pop()] = nums[i];
            }
        }
        
        
        return result;
    }
}
