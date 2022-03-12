
"""
time: O(N)
space: O(N)

"""

class Solution:
    def nextGreaterElements(self,nums):
        n = len(nums)
        i = 0
        stack = []
        lookup = [-1]*n
        while i < 2*n: # To handle the search space from j+1 to n and then from 0 to j-1
            while stack and nums[i%n] > nums[stack[-1]]:
                lookup[stack[-1]] = nums[i%n]
                stack.pop()
            if lookup[i%n] == -1: # If the next element of i%n is not found yet.
                stack.append(i%n)
            i += 1
        return lookup   