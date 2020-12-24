#Time Complexity : O(3n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        stack = []
        result = [-1 for _ in range(len(nums))]
        n = len(nums)
        for i in range(2*n):
            #while stack is not empty and current number greater than the number at index at the top of the stack
            while stack and nums[i%n] > nums[stack[-1]]:
                result[stack.pop()] = nums[i%n]
            #if it is the first iteration of the array
            if i < n:
                stack.append(i)

        return result
