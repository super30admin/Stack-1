'''
Time Complexity: O(n)
Space Complexity:O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a stack of indexes - the stack contains all indexes of temperature values whose max we don't know,
if the temperature value of the ith element is greater than the top of the stack temperature value then this is the
new maximum temperature, so pop all the temperatures which are in the stack which have a temperature value less than
the current temperature value and update their max in the result array.
'''

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = []
        res = [0 for i in range(len(T))]

        for index in range(0, len(T)):

            while len(stack) != 0 and T[index] > T[stack[-1]]:
                priorIndex = stack.pop()
                res[priorIndex] = index - priorIndex

            stack.append(index)

        return res