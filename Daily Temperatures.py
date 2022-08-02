# time complexity is o(n), where n is the size of the input
# soace complexity is o(n), where n is the size of the input
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = list() #space o(n)
        res = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures)): # time o(2n)
            while(len(stack) > 0 and temperatures[stack[-1]] < temperatures[i]):
                idx = stack.pop()
                res[idx] = i - idx 
            stack.append(i)
        return res
            
        
        