class Solution:
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if nums==None or len(nums)==0:
            return []
        n=len(nums)
        result=[-1]*n
        stack1=[]
        for i in range(0,2*n):
            while len(stack1)!=0 and nums[i%n]>nums[stack1[-1]]:
                #resolvable
                idx=stack1.pop()
                result[idx]=nums[i%n]
            stack1.append(i)
            
            if i<n:
                stack1.append(i)
        return result
    
        
#time is O(3n)
#space is O(n)
