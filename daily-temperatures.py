'''

TC: O(n)
SC: O(n)

'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        tlen = len(temperatures)
        res = [0 for i in range(tlen)]
        
        if tlen <= 1:
            return res
        
        stack = list()
        
        for idx in range(tlen):
            if not stack or temperatures[idx] <= temperatures[stack[-1]]:
                stack.append(idx)
                continue
                
            while stack and temperatures[stack[-1]] < temperatures[idx]:
                top = stack.pop()
                res[top] = idx - top 
            
            stack.append(idx)
        
        while stack:
            res[stack.pop()] = 0
        
        return res