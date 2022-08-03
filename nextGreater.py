# https://leetcode.com/problems/next-greater-element-ii/
# Approach : Monotonic decreasing Stack
# Algorithm noted in comments below
# TC: O(3n) or dropping constants O(n) as each index or value can be processed upto 3 times
# SC: O(n) Stack space
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1] * len(nums)
        
        if not nums or n == 0: return res
        # stack
        st = []
        # Iterate over nums twice - accounting for the fact that
        # this is a circular array & next greater number may be behind
        for i in range(2*n):
            # i%n helps us get correct index for the first and second pass
            # while num at curr index is greater than top of stack(notice we push indices on stack
            # and not the actual number) and stack is not empty 
            while st and nums[i%n] > nums[st[-1]]:
                # pop the index from stack top
                idx = st.pop()
                # and set current number at i%n th index as res at idx
                # meaning current number is next greater number for num[idx]
                # hence store it in the res[idx]
                res[idx] = nums[i%n]
            if i < n:
                st.append(i)
        return res