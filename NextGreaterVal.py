#Time Complexity -- O(N)
#Space Complexity -- O(N)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return []
        
        n = len(nums)
        stack = []
        stack.append(0)
        result = [-1]*n
        
        for i in range(1, 2*n):
            
            while stack and nums[i%n] > nums[stack[-1]]:
                    result[stack[-1]] = nums[i%n]
                    stack.pop()
            
            if i < n:        
                stack.append(i)
            
        return result
        
