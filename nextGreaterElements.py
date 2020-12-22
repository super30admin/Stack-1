"""
Time complexity O(3N)
Space complexity O(N)

"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if(not nums):
            return []
        
        n=len(nums)
        st=[]
        res=[-1]*n
        for i in range(2*n):
            while st and nums[i%n] > nums[st[-1]]:
                res[st.pop()]=nums[i%n]
            if(i<n):
                st.append(i) #push into stack only once 
        
        return res
        