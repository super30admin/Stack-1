'''
# Time complexity - O(N) 
# Space Complexity: O(N) for stack
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Maintain the index in stack , if no further greater element is found for that index then traverse to 2n elements as it is circular array.

'''
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1]*len(nums)

        if nums is None or len(nums) == 0:
            return result
        n = len(nums)
        stack = []
        
        for i in range(2*len(nums)):
            
            while (len(stack)>0 and nums[i%n]>nums[stack[-1]]):
                
                idx = stack.pop()
                result[idx] = nums[i%n]
                
            if i < n:
                stack.append(i)
                
        return result