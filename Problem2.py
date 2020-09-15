#Time complexity: O(3n)
#Space complexity: O(n)
#Works on leetcode: yes
#Appraoch:We keep a stack to track all the indices while iterating through the nums twice. At each iteration, we check if
# stack is not empty and the element from nums wrt index at top of stack is less than current element. We pop it from stack and
#set the ans[popped element] with the nums[i] 

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #print(range(len(nums))*2)
        res, stack = [-1]*len(nums), []
        for i in range(len(nums))*2:
            #print(i)
            while stack and nums[stack[-1]]<nums[i]:
                res[stack.pop()]=nums[i]
                #print(res)
            stack.append(i)
        return res