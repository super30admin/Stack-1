'''
Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]: # type: ignore
        if nums == None or len(nums) == 0:
            return []

        n = len(nums)
        result = [-1 for i in range(n)]
        stack = []
        for i in range(2*n):
            while stack and nums[i%n]>nums[stack[-1]]:
                popped = stack.pop()
                result[popped] = nums[i%n]
            if i < n:
                stack.append(i)
        return result               