# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        numLen = len(nums)
        nums = nums + nums

        n = len(nums)
        res = [0] * n
        stack = []
        for i in range(n-1, -1, -1):
            while stack and nums[i] >= stack[-1]:
                stack.pop()
            if stack:
                res[i] = stack[-1]
            else:
                res[i] = -1
            stack.append(nums[i])
        return res[:n//2]
