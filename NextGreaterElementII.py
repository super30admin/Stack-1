# TC: O(n)
# SC: O(n)
# LeetCode: Y(https://leetcode.com/problems/next-greater-element-ii/)
# Approach: Use a stack to update the next greater elements, since the array is cyclic the algorithm traverses twice over the input nums array


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # Initialize stack
        stack = []
        
        # check edge case
        if not nums or len(nums) == 0:
            return stack
        
        # intiailaze result list
        result = [-1 for _ in range(len(nums))]
        
        # loop twize over the nums list    
        for x in range(2):
            # loop over the nums list
            for index, value in enumerate(nums):
                # update next greater values on the indices in the stack
                while stack and value > nums[stack[-1]]:
                    result[stack.pop()] = value                    
                    
                # prevent unncecessary push on the stack during the second traversal of nums list    
                if(x == 0):
                    stack.append(index)
                
        # return result list
        return result
        
