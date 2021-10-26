# // Time Complexity :O(3n) 
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        st=[]
        result=[-1 for i in range(len(nums))]
        st.append(0)
        for i in range(len(nums)):
            while st and nums[st[-1]]<nums[i]:
                top=st.pop()
                result[top]=nums[i]
            
            st.append(i)
        print(result)
        for i in range(len(nums)):
            while st and nums[i]>nums[st[-1]]:
                top=st.pop()
                result[top]=nums[i]
        return result
                