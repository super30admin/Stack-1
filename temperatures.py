#TC = O(n)
#SC = O(n)
# Did it work in leetcode: Yes

class Solution:
    
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if len(temperatures) == 0:
            return result
        stack = []
        n=len(temperatures)
        result = [0] * n
        
        for i in range(n):
            while len(stack) != 0 and temperatures[i] > temperatures[stack[-1]]:
                popped = stack.pop()
                result[popped] = i - popped
            
            stack.append(i)
        return result
            
            
        