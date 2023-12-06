# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

#  we add elems into a stack and follow the same logic as temperature one - only the rannge changes for the for loop - twice since its circular and the value we push to res array changed 
class Solution(object):
    def nextGreaterElements(self, nums):

      """
      :type nums: List[int]
      :rtype: List[int]
      """
      # O(n), O(n)
      if(len(nums)==0):
        return []
      st=[]
      res=[-1]*len(nums)
      n=len(nums)
      for i in range(2*n):
        if(st and i%n==st[-1]):
          break
        while(st and nums[i%n]>nums[st[-1]]):
          popped=st.pop()
          res[popped]=nums[i%n]
        if(i<n):
          st.append(i)
      return res

