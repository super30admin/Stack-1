# Time Complexity: O(n)
# Space Complexity: O(n)
# ran on Leetcode: Yes

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not len(nums):
            return []
        n = len(nums)
        stack = []
        out  = [-1] * n
        for i in range(n * 2):
            temp = i % n
            while len(stack) and nums[temp] > nums[stack[-1]]:
                elem = stack.pop()
                out[elem] = nums[temp]
            stack.append(temp)
        return out