#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        result = [0]* len(temperatures)
        stack = []
        
        for i in range(len(temperatures)):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                curr = stack.pop()
                result[curr] = i-curr
                    
            stack.append(i)
            
        return result
                    