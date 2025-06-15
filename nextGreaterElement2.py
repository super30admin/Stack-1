# Time Complexity  :O(3n)
# Space Complexity :O(n)
class Solution:
    def nextGreaterElements(self, nums):
        n = len(nums)
        stack = []
        res = [-1] * n
        for i in range(2*n):
            while stack and nums[i%n] > stack[-1][0]:
                num, idx = stack.pop()
                res[idx] = nums[i%n]
            if stack and i%n == stack[-1][1]:
                break
            if i < n: 
                stack.append([nums[i], i])
        return res