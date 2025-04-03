class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1] * n  
        stack = []  
        
        for i in range(2 * n):  
            while stack and nums[i % n] > nums[stack[-1]]:
                prev_index = stack.pop()
                result[prev_index] = nums[i % n]
            
            if i < n:  # Only push indices in the first pass
                stack.append(i)
        
        return result