#739 daily temperatures
# time - O(n)
# space - O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        stack = []
        result = [0] * len(temperatures)
        
        for i in range(len(temperatures)):
            
            while(len(stack) != 0  and temperatures[stack[-1]] < temperatures[i]):
                
                pop = stack.pop()
                result[pop] = i - pop
            
            stack.append(i)
        
        return result