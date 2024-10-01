# Time complexity - O(n)
# Space complexity - O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        res = [-1] * n
        for i in range(2*n):
            i %= n
            while stack and nums[i] > nums[stack[-1]]:
                    res[stack.pop()] = nums[i]
            if i < n:
                stack.append(i)
            # if i == stack[-1]: break

        return res




