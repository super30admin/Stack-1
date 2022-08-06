# TC : O(n)
# SC : O(1)
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = [-1] * len(nums)
        mstack = []
        
        for i in range(2*(len(nums))):            
            while (len(mstack)!=0 and nums[mstack[-1]]<nums[i%len(nums)]):
                greater = nums[i%len(nums)]
                result[mstack[-1]] = greater
                mstack.pop()         
            
            if (i<len(nums)):
                mstack.append(i)
                
        return result