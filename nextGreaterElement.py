'''
Time Complexity: O(n)
Space Complexity:O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a stack of indexes - the stack contains all indexes of the next greater element value whose max
we don't know, if the temperature value of the ith element is greater than the top of the stack value then this is the
new maximum, so pop all the values which are in the stack which have a  value less than
the current  value and update their max in the result array. For the nth element we do another pass around the array
to find its next largest element.
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []

        res = [-1 for i in range(len(nums))]
        stack = []
        n = len(nums)
        for index in range(0, 2 * n):
            while len(stack) != 0 and nums[index % n] > nums[stack[-1]]:
                priorIndex = stack.pop()
                res[priorIndex] = nums[index % n]

            # as you need to do this only for 1 pass
            if index < n:
                stack.append(index % n)

        return res

