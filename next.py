# TC==>O(n)
# SC==>O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        size = len(nums)
        res = [-1] * size
        
        for k in range(2):
            for i in range(size - 1, -1, -1):
                while stack and stack[-1] <= nums[i]:
                    stack.pop()
                res[i] = stack[-1] if stack else res[i]
                stack.append(nums[i])
        
        return res