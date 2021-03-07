# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T: return
        
        n = len(T)
        result = [0] * n
        stack = []
        
        for i in range(n):
            while stack and T[i] > T[stack[-1]]:
                idx = stack.pop()
                result[idx] = i - idx
                
            stack.append(i)
        
        return result