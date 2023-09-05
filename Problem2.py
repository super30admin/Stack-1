#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        st=[]
        result=[-1]*(len(nums))
        for i in range(0,2*len(nums)):
            if i>len(nums):
                if st[-1]==i%len(nums):
                    break
            while st and nums[i%len(nums)]>nums[st[-1]]:
                result[st.pop()]=nums[i%len(nums)]
            if i<len(nums):
                st.append(i)
        return result

        