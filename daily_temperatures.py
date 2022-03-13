# tc and sc  : O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        res = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]: # monotonic stack, only less numbers are pushed into it
                p = stack.pop()
                res[p] = i - p

            stack.append(i)
        return res
        
        
                
                
            
        
