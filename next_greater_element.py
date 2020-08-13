# Time Complexity : O(3n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a stack, if current element > peak element, update the result, and pop the stack since the lement would be resolved

2. If curr element is not > peek element than, it won't be able to resolve any other element in the stack, so move forward

3 Since it is a circular array traverse upto 2*n n being the lenegth and use modulo operation to avoid overflow, As you move foward keep pushing the index on to stack but only in the first pass.
'''


from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        if not nums or len(nums) < 1:
            return
        
        stack = deque()
        result = [-1]*len(nums)
        
        n = len(nums)
        for i in range(2*n):
            
            while len(stack) > 0:
                
                peek_ind = stack[-1]
                if nums[i%n] > nums[peek_ind]:
                    result[peek_ind] = nums[i%n]
                    stack.pop()
                else:
                    break

            if i < n:
                stack.append(i)
                
        return result
        
        
        