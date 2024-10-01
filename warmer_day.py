# Time complexity - O(n)
# Space complexity - O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        stack = []
        for i in range(len(temperatures)-2,-1,-1):
            if temperatures[i] < temperatures[i+1]:
                stack.append(i+1)
                res[i] = 1
                continue
            while stack and ( temperatures[i] >= temperatures[stack[-1]]):
                stack.pop()
            res[i] = stack[-1] - i  if stack else 0
            stack.append(i)
        return res   

        
