# https://leetcode.com/problems/next-greater-element-ii/description/

# Monotonically increasing stack pattern => 2 passes 
# TC: O(n)
# SC: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * n
        st = []

        for i in range(2*n):
            
            while st and nums[i % n] > nums[st[-1]]:
                popped = st.pop()
                res[popped] = nums[i % n]

            if i < n:
                st.append(i)
            elif i % n == st[-1]:
                break

        return res