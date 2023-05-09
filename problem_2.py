# TC - O(3n)
# SC - O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * n 
        stack = []

        for i in range(2*n):
            while stack and nums[i%n] > nums[stack[-1]]:
                popped = stack.pop()
                res[popped] = nums[i%n]
            if i < n:
                stack.append(i)
           

        return res
