# Time Complexity: O (n)(Where n is total numbers) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# It can be solved using stack. Stack will contain number's index where numbers are in descending order. Tun this for 2n length and do modulo on index.
# If current number is greater than top of stack, we will pop numbers until either stack is empty or this condition is false.
# As index is obtained by pop, We will update answer for popped element by finding it's index and updating it with current element. Also push elemnet's index for every element.

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
#       Initialize answer and stack.
        n = len(nums)
        stack = []
        res = [-1] * n
        count = 0
        
#       Iterate over every element twice and push it's index to the stack.
        for i in range(2 * n):
#           Do modulo on index to start from 0 index after passing length
            i = i % n
#           While stack is not empty and top of stack number is less than current number, pop the elements.
            while stack and nums[stack[-1]] < nums[i]:
#               Update result for popped element. current will have index, so we can use it to store answer as current indexed element.
                cur = stack.pop()
                res[cur] = nums[i]
#           Pushing current elements index
            stack.append(i)
            
        return res
