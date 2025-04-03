class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0]*len(temperatures)
        stack =[]
        for i,temperature in enumerate(temperatures):
            while stack and temperature > temperatures[stack[-1]]:
                previndx = stack.pop()
                result[previndx] = i - previndx
            stack.append(i)
        return result