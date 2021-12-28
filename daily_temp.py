# TC==>O(n)
# SC==>O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []  
        size = len(temperatures)
        res = [0]*size
        for i in range(size-1, -1, -1):
            while stack!=[] and temperatures[i]>=stack[-1][0]:
                stack.pop(-1)
            if stack==[]: 
                res[i] = 0
            else:
                res[i] = stack[-1][1]-i
            stack.append((temperatures[i], i))  
        return res