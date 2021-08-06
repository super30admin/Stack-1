class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #time: O(4n)
        #space: O(n)
        result = [-1 for i in xrange(len(nums))]
        tempStack = []
        n = len(nums)
        # 2 rounds for circle condition, not adding to stack in second round
        for i in xrange(n*2):
            # if tempStack and i%n == tempStack[-1]:
            #     break
            while tempStack and nums[tempStack[-1]] < nums[i%n]:
                top = tempStack.pop()
                result[top] = nums[i%n]
            if i < n:
                tempStack.append(i)
        
        return result
