class Solution(object):
    def nextGreaterElements(self, nums):
        #O(3n)> 2time array iterate and one time stack while loop
        #O(n)>stack
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        """"
        It is almost the same as  daily temp question. The only difference is that we traverse the array twice
to find out bigger number if any exists.
        """
        res=[-1]*len(nums)
        stack = []
        n=len(nums)
        for num in range(2*n):
            #cyclic index check
            while stack and nums[stack[-1]] < nums[(num%n)]:
                top = stack.pop()
                res[top] = nums[num%n]
            #since its cyclic>so check if index is in range
            if num<n:
                stack.append(num)
        return res