# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        st = []
        res = [-1] * len(nums)
        maxSoFar = float("-inf")
        
        for i in range(len(nums)):
            maxSoFar = max(maxSoFar, nums[i])
            while st and nums[i] > nums[st[-1]]:
                j = st.pop()
                res[j] = nums[i]
            st.append(i)
        
        if nums[st[-1]] < maxSoFar: # if top of stack is max no point in trying to resolve.
            for i in range(len(nums)):
                while st and nums[i] > nums[st[-1]]:
                    j = st.pop()
                    res[j] = nums[i]
                if nums[st[-1]] == maxSoFar: # if top of stack is max no point in trying to resolve. break out.
                    break
        
        return res