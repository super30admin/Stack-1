#leetcode:accepted
#no doubts
#time complexity:O(N)
#space complexity:O(n)
#explination: Similar to daily temperature problem but here we traverse the array second time to check for actual greater elements

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[-1] * len(nums)
        stack=[]
        for x in range(len(nums)*2):
            i=x%len(nums)
            while(len(stack)!=0 and nums[i] > nums[stack[len(stack)-1]]):
                result[stack[len(stack)-1]]=nums[i]
                stack.pop(len(stack)-1)
            stack.append(i)
        return result