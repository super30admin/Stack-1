class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        maxStack = []
        n = len(temperatures)
        res = [0 for i in range(n)]

        for i in range(n):
            while maxStack and temperatures[i] > temperatures[maxStack[-1]]:
                index = maxStack.pop()
                res[index] = (i - index)
            maxStack.append(i)

        return res