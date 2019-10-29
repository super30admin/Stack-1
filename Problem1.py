# Time Complexity: O (n)(Where n is total temperatures) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# It can be solved using stack. Stack will contain number's index where numbers are in descending order.
# If current number is greater than top of stack, we will pop numbers until either stack is empty or this condition is false.
# As index is obtained by pop, We will update answer for popped element by finding index difference between current element and popped element. Also push elemnet's index for every element.

class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
#       Initialize answer and stack.
        lengthT = len(T)
        ans = [0] * lengthT
        stack = []
        
#       Iterate over every element and push it's index to the stack.
        for i in range(lengthT):
#           While stack is not empty and top of stack number is less than current number, pop the elements.
            while(stack and T[stack[-1]] < T[i]):
                current = stack.pop()
#               Update result for popped element. current will have index, so we can use it to store answer as current index minus popped index.
                ans[current] = i - current
#           Pushing current elements index
            stack.append(i)
            
        return ans
