/*
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        
        n = len(nums)
        result = [-1]*n
        stack = []
        
        for i in range(2*n):
            while len(stack) > 0 and nums[stack[-1]] < nums[i%n]:
                result[stack.pop()] = nums[i%n]
                
            if i<n:
                stack.append(i)
        return result

class Solution:
def nextGreaterElements(self, nums: List[int]) -> List[int]:
    if nums is None or len(nums) == 0:
        return []
    
    n = len(nums)
    result = [-1]*n
    stack = []
    
    for i in range(2*n):
        if len(stack) > 0 and stack[-1] == i % n: # if we rotate and come to same point and didnt find any greater element no need to check further
            break
        while len(stack) > 0 and nums[stack[-1]] < nums[i%n]:
            result[stack.pop()] = nums[i%n]
            
        if i<n:
            stack.append(i)
    return result
*/

// time - O(2n) + O(n) for stack so its O(n)
//space - O(n) for stack
// logic - i maintained the index in stack if we dont find any greater element for it and I travel to 2n elements as it is circular array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<2*n; i++){
            if (!s.isEmpty() && s.peek() == i%n)
                break;
            
            while (!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                result[s.pop()] = nums[i%n];
            }
            if (i<n){
                s.push(i);
            }
        }
        return result;
    }
}