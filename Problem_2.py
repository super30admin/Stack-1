"""
Time Complexity : O(3n)- worst case. 2n for traversing the array 2 times and n for popping all the elements out
of the stack 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
It is almost the same as  daily temp question. The only difference is that we traverse the array twice
to find out bigger number if any exists.
"""


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums
        l = len(nums)
        arr = [-1 for i in range(l)]
        stack = []
        for i in range(2*l):
            while stack and nums[i % l] > nums[stack[-1]]:
                arr[stack[-1]] = nums[i % l]
                stack.pop()
            if i < l:
                stack.append(i % l)
        return arr
