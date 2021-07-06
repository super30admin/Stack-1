class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures is None or len(temperatures) == 0:
            return []
        n = len(temperatures)
        res = [0]*n
        stack = []
        for i in range(n):
            while(len(stack) > 0 and temperatures[i] > temperatures[stack[-1]]):
                idx = stack.pop()
                res[idx] = i-idx
            stack.append(i)
        return res
