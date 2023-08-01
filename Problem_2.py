"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""


# Next Greater Element II

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n=len(nums)
        result=[-1 for _ in range(n)]
        st=[]
        for i in range(2*n):
            while st and nums[st[-1]]<nums[i%n]:
                popped=st.pop()
                result[popped]=nums[i%n]
            if i<n:
                st.append(i)
        return result