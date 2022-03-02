'''
TC: O(n)
SC: O(n)
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        nlen = len(nums)
        res = [-1 for i in nums]
        
        if nlen <= 1:)
            return res
        
        stack = list()
        
        for i in range(nlen):
            if not stack or nums[stack[-1]] >= nums[i]:
                stack.append(i)
                continue
            
            while stack and nums[stack[-1]] < nums[i]:
                res[stack.pop()] = nums[i]
            
            stack.append(i)
        
        i = 0
        while i < nlen and stack and stack[-1] != i:
            while stack and nums[i] > nums[stack[-1]]:
                res[stack.pop()] = nums[i]
            i += 1
        
        return res
        
        