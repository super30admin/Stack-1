# S30 Problem #134 Next Greater Element II
#LeetCode #503. https://leetcode.com/problems/next-greater-element-ii/description/

# Author : Akaash Trivedi
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# monotonic stack
# iterate twice over the array to make it circular
# use stack to store index and track next greater element
# pop when number higher than top of the stack and mark the next greater number for that top index
# Time complexity: O(n)
# space complexity O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        st = []
        res = [-1] * n
        for i in range(2*n):
            while st and nums[i%n] > nums[st[-1]]:
                popped = st.pop()
                res[popped] = nums[i%n]
            if i < n:
                st.append(i)
            elif st and st[-1] == i%n:
                # stop early if we reach the highest(max) element again on 2nd iteration
                break
        return res