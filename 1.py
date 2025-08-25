'''
Stack-1

Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)
'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]: # type: ignore
        if temperatures == None or len(temperatures) == 0:
            return []

        n = len(temperatures)
        stack = []
        result = [0 for i in range(n)]
        for i in range(n):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped = stack.pop()
                result[popped] = i - popped
            stack.append(i)
        return result        

        