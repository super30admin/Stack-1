# [4,8,2,7,5,11,8,4,5,6]
# [8,11,7,11,11,-1,11,5,6,8]
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        n = len(nums)
        result = [-1] * n
        stack = []

        for i in range(2*n):
            num = nums[i%n]
            while stack and nums[stack[-1]] < num:
                index = stack.pop()
                result[index] = num
            if i<n:
                stack.append(i)
        return result