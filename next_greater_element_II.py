# Time Complexity : O(n) because we are iterating through the array
# Space Complexity : O(n) because we are using a stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code, we use a stack to compare the current number with the previous numbers that we haven't gotten the next highest number for. 
We iterate through the array twice to take care of the circularity in the array.
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        answer = [-1 for _ in range(len(nums))]
        stack = []

        for i in range(len(nums) * 2):
            index = i % len(nums)
            while len(stack) != 0 and nums[index] > stack[-1][0]:
                popped = stack.pop()
                answer[popped[1]] = nums[index]

            if answer[index] == -1: 
                stack.append([nums[index], index])

        return answer 