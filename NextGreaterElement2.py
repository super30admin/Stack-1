# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : So we go through the array twice to simulate the circular nature.
# For each number, we use a stack to track the next greater element efficiently.
# As soon as we find a bigger one, we update and move on, skipping repeated work.

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * n

        st = []

        for i in range(2 * n):
            while st and nums[i % n] > nums[st[-1]]:
                popped = st.pop()
                res[popped] = nums[i % n]

            if i < n:
                st.append(i)
            elif st and st[-1] == i % n:
                break

        return res
        