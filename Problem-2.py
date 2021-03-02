#Time Complexity :o(n)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if(nums==0 or len(nums)==0):
            return []
        
        stack=[]
        n=len(nums)
        res=[-1]*n
        
        for i in range(2*n):
            while(stack and nums[i%n]>nums[(stack[len(stack)-1])]):
                ind=stack.pop()
                
                res[ind]=nums[i%n]
            if(i<n):
                stack.append(i%n)
        return res
                
            