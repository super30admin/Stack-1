class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        res, stack = [0] * len(T), []
        for i in range(len(T)):
            while stack and T[stack[-1]] < T[i]:
                res[stack.pop()] = i - stack[-1]
            stack.append(i)
        return res
        
        
       # tc o(n)
       #sc o(n1)  n1 no. of increasing temperatures in T list.        
                
            
            
