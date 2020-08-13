from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1 for _ in range(len(nums))]
        stack = deque()
        for i in range(2*len(nums)):
            temp = i%len(nums)
            while stack and nums[temp]>nums[stack[-1]]:
                j = stack.pop()
                result[j] = nums[temp]
            if i<len(nums):
                stack.append(i)
        return result

#time complexity - O(n)

#space complexity - O(n), stack space

#all test cases passed