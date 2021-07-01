"""Next Greater Element II
Time Complexity: O(n)
Space Complexity: O(n)"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1]*len(nums)
        if len(nums)==0 or nums is None:
            return result
        n = len(nums)
        index = 0
        stack = []
        for i in range(2*n):
            while stack and nums[i%n]>nums[stack[-1]]:
                index = stack.pop()
                result[index]=nums[i%n]
            if i<n:
                stack.append(i)
        return result
        
        