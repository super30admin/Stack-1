"""
https://leetcode.com/problems/daily-temperatures/

Brute force - two for loops and for each temperature we check how far is the next warmer day

Using stacks - 
We will use a result array set as all 0s initially
We will keep adding indices of days when the temperature is greater than the next day till we find a warmer day
We then pop out an element and store the difference between indices of the warmer (next)day and current index at that index

We are using the concept of monotonically increasing stack

TC = O(n)
SC = O(n)
"""

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack =[]
        n = len(temperatures)
        result = [0]*n
        
        for i in range(n):
            while stack and temperatures[i]>temperatures[stack[-1]]:
                index = stack.pop()
                result[index]= i- index
            stack.append(i)
        return result                