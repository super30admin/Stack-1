#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res=[-1]*len(nums)
        st=[]
        for i in range(len(nums)*2):
            while st and nums[st[-1]] < nums[i%len(nums)]:
                res[st.pop()]=nums[i%len(nums)]
            if i<len(nums):
                st.append(i)
        return res