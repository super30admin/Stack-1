# APPROACH 1: Stack solution
# Time Complexity : O(2n), n: len(nums)
# Space Complexity : O(n), due to space of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Iterate the array twice. Handle the index appropriately. 
# 2. Keep pushing the indices of the lower elements in stack. If the current element is greater than the top of stack, then copy this value to it's corressponding result. Keep 
#    resolving this till this new element is less than top of stack
# 3. In second pass of array, we dont add anything to stack. we only want use it to resolve elements in stack. 
# 4. If no greater element is found (reached back to the same index), place -1 in it's result. 



class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) < 1:
            return []
        
        result = [-1 for _ in range(len(nums))]
        stack = [0]
        
        for ind in range(1, 2 * len(nums)):
            i = ind % len(nums)
            
            while stack and nums[i] > nums[stack[-1]]:
                if i == stack[-1]:
                    stack.pop()
                else:
                    result[stack.pop()] = nums[i]
                    
            if ind < len(nums):
                  stack.append(i)
                                  
        return result
