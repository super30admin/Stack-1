class Solution:
    
    """
    Description: find next greater element (circular -> can restart from the begining of the given array)
    
    Time Complexity: O(n) {exact: O(3n)}
    Space Complexity: O(n) {stack}
    
    Approach: Use stack
    1. start with a empty stack and result array with all values as -1
    2. update the result array by running the loop twice (to account for cirular reference from begining)
    3. update stack only once to realize the item either resolved by choosing a greater value from given array and out of current stack or in the stack
    4. replace the result at index popped out from the stack with greater value from original array
    """
    
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
       
        if nums == None or len(nums) == 0: return
        
        n = len(nums)
        stack = []; result = [-1]*n
        
        for i in range(2*n):
            while len(stack) != 0 and nums[stack[-1]] < nums[i % n]: # resolve
                idx = stack.pop()
                result[idx] = nums[i % n]
            
            if i < n: stack.append(i)
        
        return result
