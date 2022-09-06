"""
Runtime Complexity: O(3n) - since 3 is constant its O(n).
Space Complexity: O(n) - stack space.
Yes, the code worked on leetcode.
Issues while coding - No
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums or len(nums)==0:
            return []
        if len(nums)==1:
            return [-1]
        n = len(nums)
        st = []
        result = [-1 for i in range(n)]
        
        for i in range(0,2*n):
            while st and nums[i%n]>nums[st[len(st)-1]]:
                idx = st.pop()
                result[idx] = nums[i%n]
            if i<n:
                st.append(i)
        return result