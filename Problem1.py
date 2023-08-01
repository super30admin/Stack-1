
'''
Problem: Daily Temperatures
Time Complexity: O(n), where n is given elements
Space Complexity: O(n) for stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Maintained a montonic decreasing stack
        as soon as warmer temperature is encountered, it resolves the elements in stack  
'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n

        stack=[]

        for i in range(n):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                idx = stack.pop()
                result[idx] = i - idx
            stack.append(i)

        return result