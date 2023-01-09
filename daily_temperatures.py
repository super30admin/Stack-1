class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
    
        ## T.C = O(n)
        ## S.C = O(n)
    
        n = len(temperatures)
        stack = [[0, temperatures[0]]]
        res = [0]*n

        for i in range(1, n):
            while stack and stack[-1][1] < temperatures[i]:
                x, y = stack.pop()
                res[x] = i - x
            stack.append([i, temperatures[i]])

        return res