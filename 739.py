# TC : O(n)
# SC O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if len(temperatures) == 0:
            return []
        stack = []
        result = [0]*len(temperatures)
        for i , t in enumerate(temperatures):
            while stack and t > stack[-1][1]:
                stacki, stackt = stack.pop()
                result[stacki] = i - stacki
            stack.append((i,t))
        
        return result

        