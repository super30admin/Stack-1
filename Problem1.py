## Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures==None or len(temperatures) == 0:
            return []
        n = len(temperatures)
        result = [0 for _ in temperatures]
        stack = [0] * n
        idx = 0
        for i in range(n):
            while len(stack)!=0 and temperatures[i]>temperatures[stack[-1]]:
                idx = stack.pop()
                result[idx] = i-idx
            stack.append(i)
        return result
    
#Time Complexity: O(n)
#Space Complexity: O(n)
#Approach: using stack to store index and temperature value, take the top of the element compare it with the other elements in the array. 
