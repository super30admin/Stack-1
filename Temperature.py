#Time Complexity -- O(N)
#Space Complexity -- O(N) -- worst case

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        
        if not T:
            return []
        
        
        stack = []
        stack.append(0)
        result = [0]*len(T)
        
        for i in range(1, len(T)):
            
            while stack and T[i] > T[stack[-1]]:
                    result[stack[-1]] = (i-stack[-1])
                    stack.pop()
                    
            stack.append(i)
            
        return result
