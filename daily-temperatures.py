''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        n = len(temperatures)
        result = [0] * n
        stack.append(0)
        for i in range(1,n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                poped = stack.pop()
                result[poped] = i - poped
            stack.append(i)
        
        return result



        