# TC - O(n)
# SC - O(n)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0]* n 
        stack = []
        for i in range(n):
             while stack and temperatures[i] > temperatures[stack[-1]] :
                 popped = stack.pop()
                 res[popped] = i-popped
             stack.append(i)
        return res