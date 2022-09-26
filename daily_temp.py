#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def dailyTemperatures(self, T):
        result = [0]*len(T)
        s = deque()
        for curr in range(len(T)-1,-1,-1):
            while s and T[s[-1]] <= T[curr]:
                s.pop()
            result[curr] = s[-1] - curr if s else 0
            s.append(curr)
        return result
