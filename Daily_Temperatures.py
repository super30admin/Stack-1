class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        if not temperatures:
            return []
        
        stack = []
        result = [0] * len(temperatures)
        
        for i in range(len(temperatures)):
   
            while stack and temperatures[i] > temperatures[stack[-1]]:
                idx = stack.pop()
                #print(temperatures[idx], temperatures[i])
                result[idx] = i - idx
            stack.append(i)
        return result
